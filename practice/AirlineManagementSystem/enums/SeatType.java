package Low_Level_Design.practice.AirlineManagementSystem.enums;

public enum SeatType {
    ECONOMY(10000.00),
    BUSINESS_CLASS(20000.00),
    FIRST_CLASS(40000.00);

    double price;
    SeatType(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
}
