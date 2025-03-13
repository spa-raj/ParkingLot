package controllers;

import dto.GenerateTicketRequestDto;
import dto.GenerateTicketResponseDto;
import exceptions.InvalidGateException;
import exceptions.NoAvailableParkingSpotException;
import models.Gate;
import models.GenerateTicketResponseStatus;
import models.Ticket;
import models.Vehicle;
import services.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {
        Ticket ticket=null;
        try {
           ticket = ticketService.generateTicket(generateTicketRequestDto.getLicensePlate(),
                    generateTicketRequestDto.getVehicleType(), generateTicketRequestDto.getGateId());
        } catch (InvalidGateException e) {
            throw new RuntimeException(e);
        } catch (NoAvailableParkingSpotException e) {
            throw new RuntimeException(e);
        }
        GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
        generateTicketResponseDto.setTicket(ticket);
        if(ticket!=null) {
            generateTicketResponseDto.setGenerateTicketResponseStatus(GenerateTicketResponseStatus.SUCCESS);

        }
        else {
            generateTicketResponseDto.setGenerateTicketResponseStatus(GenerateTicketResponseStatus.FAILURE);
        }
        return generateTicketResponseDto;
    }
}
