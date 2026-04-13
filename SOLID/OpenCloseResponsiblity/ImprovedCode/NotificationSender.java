package Low_Level_Design.SOLID.SingleResponsibility.Example4.ImprovedCode;

import java.util.List;

public class NotificationSender {
    public void sendNotification(List<Notification> notification, String message){
        for(Notification notifications : notification){
            notifications.sendMessage(message);
        }
    }
    
}
