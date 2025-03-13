package dto;

import lombok.Getter;
import lombok.Setter;
import models.Gate;
import models.Vehicle;
import models.VehicleType;

@Getter
@Setter
public class GenerateTicketRequestDto {
    private String licensePlate;
    private VehicleType vehicleType;
    private Long gateId;
}
