package Low_Level_Design.Problems.RateLimiter.models;

import java.time.LocalDateTime;

public class Response {
    public final Boolean isAllowed;
    public final double remaining;
    public final LocalDateTime retryAfter;

    public Response(Boolean isAllowed, double remaining, LocalDateTime retryAfter){
        this.isAllowed = isAllowed;
        this.remaining = remaining;
        this.retryAfter = retryAfter;
    }

    @Override 
    public String toString(){
        return "isAllowed " + isAllowed + " , remaining : " + remaining + " ,retryAfter " + retryAfter;
    }
    
}
