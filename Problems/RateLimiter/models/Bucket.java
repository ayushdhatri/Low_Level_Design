package Low_Level_Design.Problems.RateLimiter.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bucket {
    private double token;
    private LocalDateTime lastRefillTime;
    public Bucket(double initalToken, LocalDateTime createdAt){
        this.token = initalToken;
        this.lastRefillTime = createdAt;
    }

    public double getCurrentToken(){
        return this.token;
    }

    public LocalDateTime getLastRefillTime(){
        return this.lastRefillTime;
    }

    public void setCurrentToken(double token){
        this.token = token;
    }

    public void setLastRefillTime(LocalDateTime timeStampAfterRefill){
        this.lastRefillTime = timeStampAfterRefill;
    }
    


}
