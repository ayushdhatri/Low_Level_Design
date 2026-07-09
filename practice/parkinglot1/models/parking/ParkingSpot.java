package Low_Level_Design.practice.parkinglot1.models.parking;

import java.lang.classfile.ClassFile.Option;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import Low_Level_Design.practice.parkinglot1.models.mobility.Vehicle;
import Low_Level_Design.practice.parkinglot1.models.mobility.VehicleType;

public abstract class ParkingSpot {
    private final String spotId;
    private ParkingFloor parkingFloor;
    private ParkingSlotStatus parkingStatus;
    private Optional<Vehicle> vehicle;
    private Set<VehicleType> vehicleSupported;

    public ParkingSpot(ParkingFloor parkingFloor, Set<VehicleType> supportedTypes) {
        this.spotId = UUID.randomUUID().toString();
        this.parkingStatus = ParkingSlotStatus.EMPTY;
        this.parkingFloor = parkingFloor;
        this.parkingFloor.addParkingSpot(this);
        this.vehicleSupported = supportedTypes;
        this.vehicle = Optional.empty();
    }

    public String getSpotId() {
        return this.spotId;
    }

    public ParkingFloor getParkingFloor() {
        return this.parkingFloor;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return this.parkingStatus;
    }

    public Optional<Vehicle> getVehicle() {
        return this.vehicle;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (this.parkingStatus.equals(ParkingSlotStatus.OCCUPIED)) {
            System.out.println("ParkingSlot is not free");
            return false;
        }
        if (vehicleSupported.contains(vehicle.getVehicleType())) {
            // then only we can park the vehicle here
            this.parkingStatus = ParkingSlotStatus.OCCUPIED;
            this.vehicle = Optional.of(vehicle);
            return true;
        }
        return false;
    }

    public boolean unparkVehicle() {
        if (this.parkingStatus == ParkingSlotStatus.EMPTY) {
            System.out.println("Spot is already empty.");
            return false;
        }
        this.parkingStatus = ParkingSlotStatus.EMPTY;
        this.vehicle = Optional.empty();
        return true;
    }
}
