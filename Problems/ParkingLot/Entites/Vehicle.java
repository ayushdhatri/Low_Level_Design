package Low_Level_Design.Problems.ParkingLot.Entites;



public class Vehicle {
    private final String licenseNumber;
    private final VehicleType vehicleType;

    public Vehicle(String licNumber, VehicleType vehicleType){
        this.licenseNumber = licNumber;
        this.vehicleType = vehicleType;

    }

    public String getLicenseNumber(){
        return this.licenseNumber;
    }

    public VehicleType getvehicleType(){
        return this.vehicleType;
    }


}