package services;

import models.ParkingSpot;
import repositories.ParkingSpotRepository;

public class ParkingSpotService {
    ParkingSpotRepository parkingSpotRepository;
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }
    public void updateParkingSpot(ParkingSpot parkingSpot) {
        // Logic to update the parking spot in the database
        // For example, using a repository to save the updated parking spot
         parkingSpotRepository.updateParkingSpotStatus(parkingSpot.getId(), parkingSpot.getParkingSpotStatus());
    }
}
