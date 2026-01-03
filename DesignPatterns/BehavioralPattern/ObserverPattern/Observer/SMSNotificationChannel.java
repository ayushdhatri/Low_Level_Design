package Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Observer;

import Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Notification.Notification;


public class SMSNotificationChannel implements NotificationObserver {
    private String phoneNumber;
    private int characterLimit = 160;
    
    public SMSNotificationChannel(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void update(Notification notification) {
        String message = notification.getMessage();
        if (message.length() > characterLimit) {
            message = message.substring(0, characterLimit - 3) + "...";
        }
        
        System.out.println("\n📱 SMS sent to: " + phoneNumber);
        System.out.println("   " + notification.getTitle());
        System.out.println("   " + message);
        System.out.println("   [" + notification.getPriority() + "]");
    }
    
    @Override
    public String getChannelName() {
        return "SMS (" + phoneNumber + ")";
    }
}