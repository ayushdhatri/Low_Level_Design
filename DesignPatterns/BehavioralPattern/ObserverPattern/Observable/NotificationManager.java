package Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observable;


import java.util.*;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Notification.Notification;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observer.NotificationObserver;


public class NotificationManager implements NotificationSubject {
    private List<NotificationObserver> observers;

    public NotificationManager(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(NotificationObserver observer) {
       this.observers.add(observer);
       System.out.println("✓ " + observer.getChannelName() + " subscribed to all events");
    }

    @Override
    public void unsubscribe(NotificationObserver observer) {
        observers.remove(observer);
        System.out.println("✓ " + observer.getChannelName() + " unsubscribed to all events");
    }

    @Override
    public void notifyObservers(Notification notification) {
        for(NotificationObserver observer : observers){
            observer.update(notification);
        }
       
    }


}