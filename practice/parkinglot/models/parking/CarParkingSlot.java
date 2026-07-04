package Low_Level_Design.practice.parkinglot.models.parking;

import java.util.Arrays;
import java.util.List;

import Low_Level_Design.practice.parkinglot.models.mobility.VehicleType;

public class CarParkingSlot extends ParkingSlot implements CarSlot {
    private String carNumber;

    CarParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, Arrays.asList(VehicleType.CAR, VehicleType.BIKE));
    }

    public String getCardNumber(){
        return this.carNumber;
    }
    
    public void setCarNumber(String carNumber){
        this.carNumber = carNumber;
    }
    
}
