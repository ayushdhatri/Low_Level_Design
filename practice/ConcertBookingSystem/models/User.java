package Low_Level_Design.practice.ConcertBookingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class User{
    private final String userId;
    private final String userName;
    private final List<Booking> userBookings = new ArrayList<>();
    
    public User(String userId,String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId(){
        return this.userId;
    }

    public String getUserName(){
        return this.userName;
    }

    public List<Booking> getUserBookings(){
        return this.userBookings;
    }

    public void addBooking(Booking booking){
        this.userBookings.add(booking);
    }
    

    
}