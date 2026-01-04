package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example2;

public class NotificationFactory {
    public static Notification createNotificationType(String type){
        if(type.equalsIgnoreCase("email")){
            return new EmailNotification();
        }
        else if(type.equalsIgnoreCase("sms")){
            return new SmsNotifications();
        }
        throw new IllegalArgumentException("Unknow Notification Method");

    }
}