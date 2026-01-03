package Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observable;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Notification.Notification;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observer.NotificationObserver;

interface NotificationSubject {
    void subscribe(NotificationObserver observer);
    void unsubscribe(NotificationObserver observer);
    void notifyObservers(Notification notification);
}