package Low_Level_Design.practice.MovieBooking.enums;

public enum SeatType{
    SILVER(100.00),
    GOLD(150.00),
    PLATINUM(200.00),
    RECLINER(300.0);

    private final double price;

    SeatType(double ticketPrice){
        this.price = ticketPrice;
    }

    public double getTicketPrice(){
        return this.price;
    }
    
}
