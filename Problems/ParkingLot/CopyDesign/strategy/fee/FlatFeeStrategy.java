package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.fee;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingTicket;

public class FlatFeeStrategy implements FeeStrategy{
    private static double RATE_PER_HOUR = 10.0;
    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getEntryTimestamp() - parkingTicket.getExitTimestamp();
        long hours = (duration/(1000 * 60 * 60)) + 1;
        return hours * RATE_PER_HOUR;
    }
    public void changeRatePerHour(double newRate){
        FlatFeeStrategy.RATE_PER_HOUR = newRate;
    }

}