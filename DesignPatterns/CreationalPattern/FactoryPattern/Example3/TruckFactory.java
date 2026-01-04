package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example3;


public class TruckFactory extends VehicleFactory{

    @Override
    public Vehicle creatVehicle() {
        return new Truck();
    }

}