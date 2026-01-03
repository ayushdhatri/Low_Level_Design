package Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observer;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Notification.Notification;
 import java.util.*;

public class EmailNotificationChannel implements NotificationObserver{
    private String emailAddress;
    private boolean sendOnlyHighPriority;

    public EmailNotificationChannel(String emailAddress, boolean sendOnlyHighPriority){
        this.emailAddress = emailAddress;
        this.sendOnlyHighPriority = sendOnlyHighPriority;
    }

    @Override
    public void update(Notification notification) {
        if (sendOnlyHighPriority && 
            notification.getPriority() != Notification.Priority.HIGH && 
            notification.getPriority() != Notification.Priority.CRITICAL) {
            return;
        }
        
        System.out.println("\n📧 EMAIL sent to: " + emailAddress);
        System.out.println("   Subject: " + notification.getTitle());
        System.out.println("   Body: " + notification.getMessage());
        System.out.println("   Priority: " + notification.getPriority());
        System.out.println("   Time: " + notification.getFormattedTimestamp());
        
    }

    @Override
    public String getChannelName() {
       return "Email (" + emailAddress + ")";
    }
    
}