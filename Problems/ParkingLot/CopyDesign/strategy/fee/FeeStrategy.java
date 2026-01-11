


package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.fee;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingTicket;

public interface FeeStrategy {

    public double calculateFee(ParkingTicket parkingTicket);

    
}