package Low_Level_Design.Problems.ParkingLot.Entites;

import java.util.*;

public class ParkingFloor {
    List<ParkingSpot> parkingSpot;



    public ParkingFloor(){
        this.parkingSpot = new ArrayList<>();
    }
    void addParkingSpot(SpotType spotType){
        parkingSpot.add(new ParkingSpot(spotType));
    }
    public Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        // logic to get avaialbe parking spot
        return null;

    }

    
}