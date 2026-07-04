package Low_Level_Design.practice.parkinglot.models.parking;

import java.util.Arrays;
import java.util.List;

import Low_Level_Design.practice.parkinglot.models.mobility.VehicleType;

public class ElectricBikeParkingSlot extends ParkingSlot implements ElectricSlot {

    ElectricBikeParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, Arrays.asList(VehicleType.ELECTRIC_BIKE));
        
    }

    @Override
    public void chargeVehicle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chargeVehicle'");
    }
    
}
