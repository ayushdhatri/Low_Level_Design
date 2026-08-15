package Low_Level_Design.practice.MovieBooking.observer;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.practice.MovieBooking.models.Bookings.Booking;

public class EventNotifier {
    private final List<Observer> observers = new ArrayList<>();
    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void update(Booking booking){
        for(Observer obs : observers){
            obs.notify(booking);
        }
    }
    
    
}
