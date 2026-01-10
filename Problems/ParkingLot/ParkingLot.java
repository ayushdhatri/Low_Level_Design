package Low_Level_Design.Problems.ParkingLot;

import java.util.*;

import Low_Level_Design.Problems.ParkingLot.Entites.ParkingFloor;
import Low_Level_Design.Problems.ParkingLot.Strategy.FeeStrategy.FeeStrategy;
import Low_Level_Design.Problems.ParkingLot.Strategy.FeeStrategy.FlatRateFeeStrategy;

public class ParkingLot{
    // this is heart of our product
    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    private FeeStrategy feeStrategy;

    //
    public ParkingLot(){
        this.feeStrategy = new FlatRateFeeStrategy();
    }

    public static ParkingLot getInstance(){
        if(instance != null){
            return instance;
        }
        return new ParkingLot();
    }

    public void addFloor(String floorName){
    
    }
     public void setFeeStrategy (FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void assignEntryGate(){


    }

    public void assignExitGate(){

    }

    public Optional<Boolean> parkVehicle(Vehicle vehicle){
        // part this vehicle
    }

    public Optional<Boolean> unparkVehicle(String spotId){


    }
    





}