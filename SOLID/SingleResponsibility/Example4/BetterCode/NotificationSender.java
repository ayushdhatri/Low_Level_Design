package Low_Level_Design.SOLID.SingleResponsibility.Example4.BetterCode;

import java.util.List;

public class NotificationSender {
    public void sendNotifications(List<String> notificationTypes, String message){
        for(String notificationType : notificationTypes){
            switch (notificationType) {
                case "SMS":
                    new SmsNotification().sendSMSNotification(message);
                    break;
                case "EMAIL" :
                    new EmailNotification().sendEmailNotification(message);
                    break;
                case "PUSH" : 
                    new PushNotification().sendPushNotification(message);
                    break;
                case "WHATSAPP":
                    new WhatsAppNotification().sendWhatsAppNotification(message);
                    break;
                default:
                    System.out.println("Failed to Send Message, No method exist");
                    break;
            }

        }
    }
    
}
