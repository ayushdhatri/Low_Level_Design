package Low_Level_Design.practice.MovieBooking.observer;

import Low_Level_Design.practice.MovieBooking.models.Bookings.Booking;

public interface Observer {
    void notify(Booking booking);
} 
