package Low_Level_Design.practice.MovieBooking.observer;

import Low_Level_Design.practice.MovieBooking.models.Bookings.Booking;

public class EmailNotification implements Observer {

    @Override
    public void notify(Booking booking) {
        System.out.println("[Email Observer] Booking " + booking.getBookingId() + " confirmed for user: " + booking.getUser().getName());
    }
    
}
