package Low_Level_Design.practice.parkinglot.models.mobility;

public class ElectricBike extends Vehicle implements ElectricVehicle {

    public ElectricBike(String regNum, String color) {
        super(regNum, color, VehicleType.ELECTRIC_BIKE);
    }

    @Override
    public void charge() {
        
    }

    @Override
    public float getBatteryLevel() {
       return 0;
    }
    
    
}