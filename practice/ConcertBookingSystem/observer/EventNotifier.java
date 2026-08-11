package Low_Level_Design.practice.ConcertBookingSystem.observer;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.practice.ConcertBookingSystem.models.Booking;

public class EventNotifier {
    private final List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer){
        this.observers.add(observer);
    }

    public void update(Booking booking){
        for(Observer observer: observers){
           observer.notify();
        }
    }
    
    
}
