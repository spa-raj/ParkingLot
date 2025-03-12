package models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    int number;
    private List<ParkingSpot> parkingSpots;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ParkingSpot> getParkingSlots() {
        return parkingSpots;
    }

    public void setParkingSlots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
