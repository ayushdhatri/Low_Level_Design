package Low_Level_Design.Problems.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.RateLimiter.models.Endpoint;
import Low_Level_Design.Problems.RateLimiter.models.Request;
import Low_Level_Design.Problems.RateLimiter.models.Response;

public class RateLimiter {
    Map<String, Endpoint> endPointMapper = new ConcurrentHashMap<>();// maps endpoint string to endPoint class
    Map<String, 
    
    Response handleRequest(Request request){




        return null;
    }

    private Response isAllowed(){
        
    }

}
