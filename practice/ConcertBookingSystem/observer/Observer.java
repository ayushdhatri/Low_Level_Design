package Low_Level_Design.practice.ConcertBookingSystem.observer;

import Low_Level_Design.practice.ConcertBookingSystem.models.Booking;

public interface Observer {
    void notify(Booking booking);// here we can even create response dto as user does not need all detailspublic void notify(Booking booking);// here we can even create response dto as user does not need all details
    
}