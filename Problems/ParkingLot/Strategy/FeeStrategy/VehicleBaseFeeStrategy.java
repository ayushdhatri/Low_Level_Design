package Low_Level_Design.Problems.ParkingLot.Strategy.FeeStrategy;

import java.util.Map;

import Low_Level_Design.Problems.ParkingLot.Entites.ParkingTicket;
import Low_Level_Design.Problems.ParkingLot.Entites.VehicleType;

public class VehicleBaseFeeStrategy implements FeeStrategy{
    private static final Map<VehicleType, Double> HOURLY_RATES = Map.of(
        VehicleType.TWO_WHEELER, 50.0,
        VehicleType.FOUR_WHEELER, 100.00
    );

    @Override
    public Double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
        long hours = (duration/(1000 * 60 * 60)) + 1;
        return hours * HOURLY_RATES.get(parkingTicket.getVehicle().getvehicleType());
       
    }
    
}