package strategies.feesCalculationStrategy;

import models.Ticket;

import java.time.LocalDateTime;

public class HourlyFeesCalculationStrategy implements FeesCalculationStrategy{
    @Override
    public long calculateFees(Ticket ticket) {
        LocalDateTime startTime = ticket.getEntryTime();
        LocalDateTime endTime = LocalDateTime.now();
        long hours = java.time.Duration.between(startTime, endTime).toHours();

        long fees= 50*hours;
        return fees;
    }
}
