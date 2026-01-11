

package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.parking;

import java.util.List;
import java.util.Optional;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingFloor;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.entities.ParkingSpot;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.vehicle.Vehicle;



interface ParkingStrategy {

    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}