package Low_Level_Design.practice.ConcertBookingSystem.observer;

import Low_Level_Design.practice.ConcertBookingSystem.models.Booking;

public class SMSNotificationObserver implements Observer {

    @Override
    public void notify(Booking booking) {
        System.out.println("[SMS Observer] Sent SMS ticket link to user: " + booking.getUser().getUserName());
    }
    
}
