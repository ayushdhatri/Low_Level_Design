package Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observer;

import java.util.*;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Notification.Notification;



public interface NotificationObserver {
    void update(Notification notification);
    String getChannelName();
}