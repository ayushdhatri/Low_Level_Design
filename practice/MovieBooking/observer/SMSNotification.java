package Low_Level_Design.practice.MovieBooking.observer;

import Low_Level_Design.practice.MovieBooking.models.Bookings.Booking;

public class SMSNotification implements Observer {

    @Override
    public void notify(Booking booking) {
        System.out.println("[SMS Observer] Sent M-Ticket SMS link to user: " + booking.getUser().getName());
    }
    
    
}
