
package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingFloor;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingSpot;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.vehicle.Vehicle;

public class FarthestFirstStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
       Optional<ParkingSpot> bestSpot = Optional.empty();
       List<ParkingFloor>reversedFloors = new ArrayList<>(floors);
       Collections.reverse(reversedFloors);
       for(ParkingFloor floor : reversedFloors){
            Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);
            if(spotOnThisFloor.isPresent()){
                return spotOnThisFloor;
            }


            
        }
        return bestSpot;

    }
    
}