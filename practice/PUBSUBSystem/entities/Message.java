package Low_Level_Design.practice.PUBSUBSystem.entities;

import java.time.LocalDateTime;

public class Message {
    private LocalDateTime timeStamp;
    private String messageContent;

    public Message(String message ){
        this.messageContent = message;
        this.timeStamp = LocalDateTime.now();   
    }

    public String getPayload(){
        return this.messageContent;
    }

    public LocalDateTime getTimeStamp(){
        return this.timeStamp;
    }
    
}
