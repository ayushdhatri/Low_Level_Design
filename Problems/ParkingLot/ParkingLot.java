package Low_Level_Design.Problems.ParkingLot;

import java.util.*;

import Low_Level_Design.Problems.ParkingLot.Entites.ParkingFloor;
import Low_Level_Design.Problems.ParkingLot.Entites.Vehicle;
import Low_Level_Design.Problems.ParkingLot.Entites.ParkingSpot;
import Low_Level_Design.Problems.ParkingLot.Entites.ParkingTicket;
import Low_Level_Design.Problems.ParkingLot.Strategy.FeeStrategy.FeeStrategy;
import Low_Level_Design.Problems.ParkingLot.Strategy.FeeStrategy.FlatRateFeeStrategy;

public class ParkingLot {

    private static ParkingLot instance;

    private final List<ParkingFloor> floors = new ArrayList<>();
    private FeeStrategy feeStrategy;
    private ParkingSpot parkingStrategy;

    // Map spotId -> Ticket (so we can calculate fee on unpark)
    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();

    private ParkingLot() {
        this.feeStrategy = new FlatRateFeeStrategy();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void addFloor(String floorName) {
        ParkingFloor newFloor = new ParkingFloor(floorName);
        floors.add(newFloor);
    }

    // park vehicle -> find spot -> park -> create ticket
    public Optional<Ticket> parkVehicle(Vehicle vehicle) {

        if (parkingStrategy == null) {
            throw new IllegalStateException("ParkingStrategy not set");
        }

        Optional<ParkingSpot> spotOpt = parkingStrategy.findSpot(floors, vehicle);

        if (spotOpt.isEmpty()) {
            return Optional.empty(); // no slot available
        }

        ParkingSpot spot = spotOpt.get();

        // find which floor contains this spot
        for (ParkingFloor floor : floors) {
            if (floor.hasSpot(spot.getSpotId())) {

                boolean parked = floor.parkVehicle(vehicle, spot);
                if (!parked) return Optional.empty();

                // create ticket
                ParkingTicket ticket = new Ticket(
                        UUID.randomUUID().toString(),
                        vehicle,
                        spot.getSpotId(),
                        floor.getFloorName(),
                        System.currentTimeMillis()
                );

                activeTickets.put(spot.getSpotId(), ticket);
                return Optional.of(ticket);
            }
        }

        return Optional.empty();
    }

    public Optional<Double> unparkVehicle(String spotId) {

        // ticket exists?
        ParkingTicket ticket = activeTickets.get(spotId);
        if (ticket == null) {
            return Optional.empty();
        }

        // unpark from floor
        for (ParkingFloor floor : floors) {
            if (floor.hasSpot(spotId)) {

                boolean success = floor.unparkVehicle(spotId);
                if (!success) return Optional.empty();

                // close ticket
                ticket.setExitTime(System.currentTimeMillis());

                // calculate fee
                double fee = feeStrategy.calculateFee(ticket);

                // remove active ticket
                activeTickets.remove(spotId);

                return Optional.of(fee);
            }
        }

        return Optional.empty();
    }
}
