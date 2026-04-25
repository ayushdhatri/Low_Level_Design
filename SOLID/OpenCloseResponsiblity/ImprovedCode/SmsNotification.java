package Low_Level_Design.SOLID.OpenCloseResponsiblity.ImprovedCode;


public class SmsNotification implements Notification {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS Notification");
    }
}
