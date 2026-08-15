package Low_Level_Design.practice.MovieBooking.models.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private final String userId;
    private final Location location;
    private final LocalDate dob;
    private final List<Booking> userBookings = new ArrayList<>();

    public User(String userId, String name, Location location, LocalDate dob){
        super(name);
        this.userId = userId;
        this.location = location;
        this.dob = dob;
    }

    public String getUserId(){
        return this.userId;
    }

    public Location getLocation(){
        return this.location;
    }

    public LocalDate getDOB(){
        return this.dob;
    }

    public void changeUserLocation(Location location){
        this.location = location;
        return;
    }

    public List<Booking> getUserBookings(){
        return this.userBookings;
    }

    public void addBooking(Booking booking){
        this.userBookings.add(booking);
    }


    
    
}
