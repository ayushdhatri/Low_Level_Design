package Low_Level_Design.Problems.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.RateLimiter.models.Endpoint;

public class RateLimiter {
    Map<String, Endpoint> endPointMapper = new ConcurrentHashMap<>();// maps endpoint string to endPoint class
    
    Response isAllowed(Request request);

}
