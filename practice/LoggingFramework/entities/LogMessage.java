package Low_Level_Design.practice.LoggingFramework.entities;

import java.time.LocalDateTime;

import Low_Level_Design.practice.LoggingFramework.enums.LogLevel;

public class LogMessage {
    private final LocalDateTime timeStamp;
    private final LogLevel level;
    private final String message;
    private final String threadName;

    public LogMessage(LogLevel level, String message){
        this.message = message;
        this.level = level;
        this.timeStamp = LocalDateTime.now();
        this.threadName = Thread.currentThread().getName();
    }
    
    public String getMessage(){
        return this.message;
    }

    public LogLevel getLevel(){
        return level;
    }

    public LocalDateTime getTimeStamp(){
        return this.timeStamp;
    }

    public String getThreadName(){
        return this.threadName;
    }
}
