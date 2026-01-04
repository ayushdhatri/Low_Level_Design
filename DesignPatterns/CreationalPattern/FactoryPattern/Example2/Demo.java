package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example2;



public class Demo {
    public static void main(String[] args){
        Notification n1 = NotificationFactory.createNotificationType("sms");
        n1.notifyUser();
    }
}