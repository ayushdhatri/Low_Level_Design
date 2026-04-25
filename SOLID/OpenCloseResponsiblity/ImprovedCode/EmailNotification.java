package Low_Level_Design.SOLID.OpenCloseResponsiblity.ImprovedCode;

public class EmailNotification implements Notification {

    @Override
    public void sendMessage(String message) {
      System.out.println("Send Email Notification");
    }
    
}
