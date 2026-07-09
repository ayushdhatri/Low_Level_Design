package Low_Level_Design.practice.parkinglot1.models.parking;

import java.util.Set;

import Low_Level_Design.practice.parkinglot1.models.mobility.VehicleType;

public class CarParkingSpot extends ParkingSpot {

    public CarParkingSpot(ParkingFloor parkingFloor) {
        super(parkingFloor, Set.of(VehicleType.CAR));
        //TODO Auto-generated constructor stub
    }
    
}
