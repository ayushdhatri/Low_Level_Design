package Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Notification.Notification;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observable.NotificationManager;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observer.EmailNotificationChannel;
import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observer.SMSNotificationChannel;

public class NotificationSystemDemo {
    public static void main(String[] args){
        NotificationManager notificationManager = new NotificationManager();

        // Lets createa notification channels
        EmailNotificationChannel email = new EmailNotificationChannel("aayushdhatri@gmail.com", false);
        SMSNotificationChannel smsNotificationChannel = new SMSNotificationChannel("8291441089");

        notificationManager.subscribe(email);
        notificationManager.subscribe(smsNotificationChannel);

        // Lets create notification 
          Notification loginNotification = new Notification(
            "USER_LOGIN",
            "New Login Detected",
            "User John Doe logged in from New York, USA",
            Notification.Priority.LOW
        );

        notificationManager.notifyObservers(loginNotification);

    }


}