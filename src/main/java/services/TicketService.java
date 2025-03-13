package services;

import exceptions.InvalidGateException;
import exceptions.NoAvailableParkingSpotException;
import models.*;
import repositories.TicketRepository;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.time.LocalDateTime;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingSpotService parkingSpotService;

    public TicketService(VehicleService vehicleService,
                         GateService gateService,
                         TicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingSpotService parkingSpotService) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingSpotService = parkingSpotService;
    }

    public Ticket generateTicket(String licensePlate, VehicleType vehicleType, Long gateId) throws InvalidGateException, NoAvailableParkingSpotException {
        Ticket ticket = new Ticket();
        //Logic
        //Check if the Vehicle is already there in the DB
        // - getVehicleByVehicleNumber(String)
        //If vehicle isn't there in the Db then create the vehicle and store in the DB.

        //Way-1 : Directly call the Vehicle Repository.
        //Way-2 : Call the VehicleService and vehicleService will internally call the repository.
        // Using the way-2
        Vehicle vehicle = vehicleService.getVehicleBylicensePlate(licensePlate);
        if (vehicle == null) {
            vehicle = vehicleService.registerVehicle(licensePlate, vehicleType);
        }
        Gate gate = gateService.getGateById(gateId);
        if(gate==null){
            throw new InvalidGateException("Gate not found with id: " + gateId);
        }
        //Create the ticket
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setEntryTime(LocalDateTime.now());

        //Set the operator
        ticket.setOperator(gate.getOperator());

        // Assign the parking spot to the ticket
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignParkingSpot(vehicleType, gate);
        if(parkingSpot==null){
            throw new NoAvailableParkingSpotException("No available parking spot for vehicle type: " + vehicleType);
        }
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        // Update the parking spot in the database using the parking spot service
        parkingSpotService.updateParkingSpot(parkingSpot);
        ticket.setParkingSpot(parkingSpot);

        //Save the ticket in the DB
        ticket= ticketRepository.save(ticket);
        return ticket;
    }
}
