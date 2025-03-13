package strategies.feesCalculationStrategy;

import models.Ticket;

public interface FeesCalculationStrategy {
    long calculateFees(Ticket ticket);
}
