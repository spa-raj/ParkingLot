package dto;

import lombok.Getter;
import lombok.Setter;
import models.GenerateTicketResponseStatus;
import models.Ticket;

@Getter
@Setter
public class GenerateTicketResponseDto {
    private Ticket ticket;
    private GenerateTicketResponseStatus generateTicketResponseStatus;
}
