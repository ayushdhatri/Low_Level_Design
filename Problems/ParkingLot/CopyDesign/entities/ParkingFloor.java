package Low_Level_Design.Problems.ParkingLot.CopyDesign.entities;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Low_Level_Design.Problems.ParkingLot.CopyDesign.vehicle.Vehicle;
import Low_Level_Design.Problems.ParkingLot.CopyDesign.vehicle.VehicleSize;

public class ParkingFloor{
    private final int floorNumber;
    private final Map<String, ParkingSpot> spots;

    public ParkingFloor(int floorNumber){
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }
    public void addSpot(ParkingSpot spot){
        spots.put(spot.getSpotId(), spot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        return spots.values().stream()
            .filter(spot -> !spot.isOccupied() && spot.canFitVehicle(vehicle))
            .sorted(Comparator.comparing(ParkingSpot::getSpotSize))
            .findFirst();
    }

    public void displayAvailability(){
        System.out.printf("--- Floor %d Availability ---\n", floorNumber);
        Map<VehicleSize, Long> availableCounts =  spots.values().stream() 
            .filter(spot -> !spot.isOccupied())
            .collect(Collectors.groupingBy(ParkingSpot::getSpotSize, Collectors.counting()));
        
        availableCounts.forEach((size, count)-> {
            System.out.println(size + "->" + count);
        });
            
    }


    
}