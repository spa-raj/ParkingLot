package services;

import models.ParkingLot;
import models.ParkingSpot;
import repositories.parkingLotRepository;

import java.util.List;

public class ParkingLotService {
    private final parkingLotRepository parkingLotRepository;

    public ParkingLotService(parkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public List<ParkingSpot> getParkingSpots(Long parkingLotId) {
        return null;
    }
    public ParkingLot getParkingLotByGateId(Long GateId) {
        return parkingLotRepository.findByGateId(GateId);
    }
}
