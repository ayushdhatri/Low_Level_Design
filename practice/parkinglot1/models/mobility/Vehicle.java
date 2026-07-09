package Low_Level_Design.practice.parkinglot1.models.mobility;

public abstract class Vehicle {
    private final String licenseNumber;
    private final VehicleType vehicleType;

    public Vehicle(String liceString, VehicleType vehicleType){
        this.licenseNumber = liceString;
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber(){
        return this.licenseNumber;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
}
