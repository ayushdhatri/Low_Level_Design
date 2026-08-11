package Low_Level_Design.practice.ConcertBookingSystem.observer;

import Low_Level_Design.practice.ConcertBookingSystem.models.Booking;

public class EmailNotificationObserver implements Observer {
    @Override
    public void notify(Booking booking) {
        System.out.println("[Email Observer] Sent booking confirmation " + booking.getBookingId() + " to user: " + booking.getUser().getUserName());
    }
}
