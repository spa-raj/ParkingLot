package models;

import java.time.LocalDateTime;
import java.util.Date;

public class ElectricMeter extends BaseModel{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double totalUnitsConsumed;
    private double totalCost;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getTotalUnitsConsumed() {
        return totalUnitsConsumed;
    }

    public void setTotalUnitsConsumed(double totalUnitsConsumed) {
        this.totalUnitsConsumed = totalUnitsConsumed;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
