package Low_Level_Design.SOLID.SingleResponsibility.Example4.ImprovedCode;

public class EmailNotification implements Notification {

    @Override
    public void sendMessage(String message) {
      System.out.println("Send Email Notification");
    }
    
}
