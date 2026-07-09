package Low_Level_Design.practice.parkinglot1.models.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Low_Level_Design.practice.parkinglot.models.parking.ParkingSlot;

public class ParkingFloor {
    private final String floorId;
    private Map<String, ParkingSpot> parkingSpots;

    public ParkingFloor(String floorId, Map<String, ParkingSpot> parkingSpots){
        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.put(parkingSpot.getSpotId(), parkingSpot);
    }
    
}