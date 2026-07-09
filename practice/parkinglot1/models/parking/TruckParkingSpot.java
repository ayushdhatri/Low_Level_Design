package Low_Level_Design.practice.parkinglot1.models.parking;

import java.util.Set;

import Low_Level_Design.practice.parkinglot1.models.mobility.VehicleType;

public class TruckParkingSpot extends ParkingSpot {

    public TruckParkingSpot(ParkingFloor parkingFloor){
        super(parkingFloor, Set.of(VehicleType.TRUCK));
    }
    
    
}
