package strategies.spotAssignmentStrategy;

import exceptions.InvalidGateException;
import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate) throws InvalidGateException;
}
