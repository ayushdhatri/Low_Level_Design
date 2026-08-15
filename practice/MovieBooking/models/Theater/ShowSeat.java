package Low_Level_Design.practice.MovieBooking.models.Theater;

import Low_Level_Design.practice.MovieBooking.enums.ShowSeatStatus;

public class ShowSeat {
    private final String showSeatId;
    private final Seat seat;
    private ShowSeatStatus status;
    private final double price;

    public ShowSeat(String showSeatId, Seat seat, double price){
       this.showSeatId = showSeatId;
       this.seat = seat;
       this.status = ShowSeatStatus.AVAILABLE;
       this.price = price;
    }

    public String getShowSeatId(){
        return this.showSeatId;
    }

    public Seat getShowSeat(){
        return this.seat;
    }

    public double getPrice(){
        return this.price;
    }

    public ShowSeatStatus getShowSeatStatus(){
        return this.status;
    }

    public void setShowSeatStatus(ShowSeatStatus newStatus){
        this.status = newStatus;
    }



    
}
