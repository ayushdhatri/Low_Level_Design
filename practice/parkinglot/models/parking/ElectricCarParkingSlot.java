package Low_Level_Design.practice.parkinglot.models.parking;

import java.util.Arrays;
import java.util.List;

import Low_Level_Design.practice.parkinglot.models.mobility.VehicleType;

public class ElectricCarParkingSlot extends ParkingSlot implements ElectricSlot, CarSlot{

    ElectricCarParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, Arrays.asList(VehicleType.ELECTRIC_BIKE, VehicleType.ELECTRIC_CAR));
        
    }

    @Override
    public void chargeVehicle() {
        System.out.println("Charging electric car");
        
    }
    
    
}
