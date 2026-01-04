package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example3;


abstract class VehicleFactory{
    public abstract Vehicle creatVehicle();


    // common behavior using the factory method
    public void deliverGoods(){
        Vehicle vehicle = creatVehicle();
        System.out.println("Preparing delivery...");
        vehicle.drive();
        System.out.println("Deliver Complete!");
    }
}