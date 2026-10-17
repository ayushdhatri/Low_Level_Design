package Low_Level_Design.Problems.RateLimiter.Services;

import Low_Level_Design.Problems.RateLimiter.models.Request;
import Low_Level_Design.Problems.RateLimiter.models.Response;

public interface EndPointAlgorithm {
    Response isAllowed(Request request);

}
