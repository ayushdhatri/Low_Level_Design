package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example3;


public class BikeFactory extends VehicleFactory{

    @Override
    public Vehicle creatVehicle() {
        return new Bike();
    }

}