package Low_Level_Design.SOLID.OpenCloseResponsiblity.ImprovedCode;


public class WhatsAppNotification implements Notification {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending WhatsApp Notification");
    }
    
}
