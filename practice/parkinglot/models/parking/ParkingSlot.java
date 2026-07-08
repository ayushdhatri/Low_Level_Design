package Low_Level_Design.practice.parkinglot.models.parking;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import Low_Level_Design.practice.parkinglot.models.mobility.Vehicle;
import Low_Level_Design.practice.parkinglot.models.mobility.VehicleType;



public abstract class ParkingSlot {

    private final List<VehicleType> supportedVehicleType;
    private ParkingSlotStatus status;
    private int slotNumber;
    private ParkingFloor floor;
    private Optional<Vehicle> vehicle;

    ParkingSlot(int slotNumber, ParkingFloor floor, List<VehicleType> supportTypes){
        this.slotNumber = slotNumber;
        this.floor = floor;
        this.status = ParkingSlotStatus.EMPTY;
        this.floor.addParkingSlot(this);
        this.supportedVehicleType = supportTypes;
    }

     public List<VehicleType> getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public Optional<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Optional<Vehicle> vehicle) {
        boolean isVehicleTypeSupported = supportedVehicleType.contains(vehicle.get().getVehicleType());
        if(isVehicleTypeSupported){
            this.vehicle = vehicle;
            this.status = ParkingSlotStatus.OCCUPIED;
            return;
        }
        System.out.println("Vehicle type not supported, Supported Vehicle types are :" + supportedVehicleType);
    }

    public void removeVehicle(){
        this.status = ParkingSlotStatus.EMPTY;
        this.vehicle = Optional.empty();
    }

}
