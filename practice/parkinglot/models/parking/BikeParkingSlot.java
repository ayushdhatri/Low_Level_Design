package Low_Level_Design.practice.parkinglot.models.parking;

import java.util.Arrays;
import java.util.List;

import Low_Level_Design.practice.parkinglot.models.mobility.VehicleType;

public class BikeParkingSlot extends ParkingSlot implements BikeSlot {
    String bikeNumber;
    BikeParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, Arrays.toList(VehicleType.BIKE));
 
    }
    
}
