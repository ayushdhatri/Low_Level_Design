package Low_Level_Design.SOLID.SingleResponsibility.Example4.ImprovedCode;


public class SmsNotification implements Notification {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS Notification");
    }
}
