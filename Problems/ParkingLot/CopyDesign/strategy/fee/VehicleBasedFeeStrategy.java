package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.fee;

import java.util.Map;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingTicket;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.vehicle.VehicleSize;

public class VehicleBasedFeeStrategy implements FeeStrategy{
    private static Map<VehicleSize, Double> HOURLY_RATES =  Map.of(
        VehicleSize.SMALL, 10.0,
        VehicleSize.MEDIUM, 50.0,
        VehicleSize.LARGE, 100.0
    );
    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getEntryTimestamp() - parkingTicket.getExitTimestamp();
        long hours = (duration/(1000 * 60 * 60)) + 1;
        return hours * HOURLY_RATES.get(parkingTicket.getVehicle().getSize());
    }
    public void changeRatePerHour(double newRate){
       // TODO
    }

}