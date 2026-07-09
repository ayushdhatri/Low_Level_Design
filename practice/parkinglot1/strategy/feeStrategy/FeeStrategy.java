package Low_Level_Design.practice.parkinglot1.strategy.feeStrategy;

import Low_Level_Design.practice.parkinglot1.models.ticket.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}

