package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.parking;

import java.util.List;
import java.util.Optional;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingFloor;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingSpot;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.vehicle.Vehicle;

public class BestFitStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
       Optional<ParkingSpot> bestSpot = Optional.empty();
       for(ParkingFloor floor : floors){
            Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);
            if(spotOnThisFloor.isPresent()){
                if(bestSpot.isEmpty()){
                    bestSpot = spotOnThisFloor;
                }
                else{
                    if(spotOnThisFloor.get().getSpotSize().ordinal() < bestSpot.get().getSpotSize().ordinal()){
                        bestSpot = spotOnThisFloor;
                    }
                }
            }
        }
        return bestSpot;

    }
    
}