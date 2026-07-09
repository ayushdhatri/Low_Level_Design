package Low_Level_Design.practice.parkinglot1.models.parking;

import java.util.HashSet;
import java.util.Set;

import Low_Level_Design.practice.parkinglot1.models.mobility.VehicleType;

public class BikeParkingSpot extends ParkingSpot{

    public BikeParkingSpot(ParkingFloor parkingFloor) {
        super(parkingFloor, Set.of(VehicleType.BIKE));
    }
    
    
}
