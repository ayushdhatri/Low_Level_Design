package Low_Level_Design.practice.parkinglot1.strategy.feeStrategy;

import Low_Level_Design.practice.parkinglot1.config.Constants;
import Low_Level_Design.practice.parkinglot1.models.ticket.Ticket;
import Low_Level_Design.practice.parkinglot1.utility.Utils;


public class FlatRateFeeStrategy implements FeeStrategy{
    private final double RATE_PER_HOUR = Constants.RATE_PER_HOUR;

    @Override
    public double calculateFee(Ticket ticket) {
        Long duration = ticket.getExitTime().get() - ticket.getEntryTime();
        Long hours = duration/(1000 * 60 * 60);
        return RATE_PER_HOUR * hours;
    }

    
}
