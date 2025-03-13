package strategies.spotAssignmentStrategy;

import exceptions.InvalidGateException;
import models.*;
import services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class RandomSpotAssignmentStrategy implements  SpotAssignmentStrategy {
    ParkingLotService parkingLotService;
    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate) throws InvalidGateException {
        // Get the parking lot by gate ID
        ParkingLot parkingLot = parkingLotService.getParkingLotByGateId(gate.getId());
        if(parkingLot == null) {
            throw new InvalidGateException("Parking lot not found for gate ID: " + gate.getId());
        }
        // Get the list of parking spots in the parking lot
        List<ParkingSpot> parkingSpots = parkingLotService.getParkingSpots(parkingLot.getId());
        // Filter the parking spots based on vehicle type and availability
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getSupportedVehicleTypes().contains(vehicleType) && parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE){
                availableSpots.add(parkingSpot);
            }
        }
        // If no available spots, return null
        if(availableSpots.isEmpty()){
            return null;
        }
        // Randomly select a parking spot from the available spots
        int randomIndex = (int) (Math.random() * availableSpots.size());

        return availableSpots.get(randomIndex);
    }
}
