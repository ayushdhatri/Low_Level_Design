package Low_Level_Design.SOLID.OpenCloseResponsiblity.ImprovedCode;


public class PushNotification implements Notification {
    @Override
     public void sendMessage(String message) {
       System.out.println("Sending Push Notification");
    }
}
