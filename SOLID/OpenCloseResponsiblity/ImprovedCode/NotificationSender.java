package Low_Level_Design.SOLID.OpenCloseResponsiblity.ImprovedCode;

import java.util.List;

public class NotificationSender {
    public void sendNotification(List<Notification> notification, String message){
        for(Notification notifications : notification){
            notifications.sendMessage(message);
        }
    }
    
}
