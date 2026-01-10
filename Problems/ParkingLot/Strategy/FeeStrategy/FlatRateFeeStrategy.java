package Low_Level_Design.Problems.ParkingLot.Strategy.FeeStrategy;

import Low_Level_Design.Problems.ParkingLot.Entites.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy{
    private static final double RATE_PER_HOUR = 50.0;



    @Override
    public Double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
        long hours = (duration/(1000 * 60 * 60)) + 1;
        return hours * RATE_PER_HOUR;
    }

}