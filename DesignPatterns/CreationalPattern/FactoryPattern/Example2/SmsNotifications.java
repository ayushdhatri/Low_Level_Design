


package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example2;

public class SmsNotifications implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Notify user via Sms notification");
    }
}