package Low_Level_Design.practice.parkinglot.models.parking;

import java.util.List;

import Low_Level_Design.practice.parkinglot.services.ParkingLotService;

public class ParkingLot {
    private List<ParkingFloor> floors;
    ParkingLotService parkingLotService;

    ParkingLot(List<ParkingFloor> floors){
        this.floors = floors;
        this.parkingLotService = new ParkingLotService();
    }

    public void addParkingFloor(ParkingFloor parkingFloor){
        this.floors.add(parkingFloor);
    }
    
    
    
}
