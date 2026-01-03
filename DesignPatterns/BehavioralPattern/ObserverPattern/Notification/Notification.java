package Low_Level_Design.DesignPatterns.BehavioralPattern.ObserverPattern.Notification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Notification {
    private String eventType;
    private String title;
    private String message;
    private Priority priority;
    private LocalDateTime timestamp;
    private Map<String, String> metadata;

    public enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public Notification(String eventType, String title, String message, Priority priority) {
        this.eventType = eventType;
        this.title = title;
        this.message = message;
        this.priority = priority;
        this.timestamp = LocalDateTime.now();
        this.metadata = new HashMap<>();
    }

    public void addMetadata(String key, String value) {
        metadata.put(key, value);
    }

    // Getter
    public String getEventType() { return eventType; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public Priority getPriority() { return priority; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Map<String, String> getMetadata() { return metadata; }
    
    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    
    
}