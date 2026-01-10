package Low_Level_Design.Problems.ParkingLot.Entites;

import java.util.*;

public class ParkingSpot {
    public String spotId;
    private Boolean isAvilable;
    public SpotType spotType;
    private Vehicle vehicle;

    public ParkingSpot(SpotType type) {
        this.spotId = UUID.randomUUID().toString();
        this.spotType = type;
        isAvilable = true;
    }

    public Boolean isSpotAvailable(){
        return this.isAvilable;
    }

    public String getSpotId(){
        return this.spotId;
    }

    public SpotType getSpotType(){
        return this.spotType;
    }
    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvilable = false;
    }

    public void unassignVehicle(){
        this.vehicle = null;
        this.isAvilable = true;
    }
    

}