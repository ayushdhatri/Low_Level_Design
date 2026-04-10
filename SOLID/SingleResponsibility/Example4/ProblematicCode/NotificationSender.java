package Low_Level_Design.SOLID.SingleResponsibility.Example4.ProblematicCode;

import java.util.List;

public class NotificationSender {
    public void sendNotifications(List<NotificationType> notificationTypes, String message){
        for(NotificationType notificationType : notificationTypes){
            switch (notificationType) {
                case SMS:
                    notificationType.sendSMSNotification(message);
                    break;
                case EMAIL :
                    notificationType.sendEmailNotification(message);
                    break;
                case PUSH : 
                    notificationType.sendPushNotification(message);
                    break;
                case WHATSAPP:
                    notificationType.sendWhatsAppNotification(message);
                    break;
                default:
                    System.out.println("Failed to Send Message, No method exist");
                    break;
            }

        }
    }
    
}
