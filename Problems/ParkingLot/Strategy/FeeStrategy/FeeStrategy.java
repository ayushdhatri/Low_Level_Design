package Low_Level_Design.Problems.ParkingLot.Strategy.FeeStrategy;

import Low_Level_Design.Problems.ParkingLot.Entites.ParkingTicket;

public interface FeeStrategy {
    public Double calculateFee(ParkingTicket parkingTicket);
}