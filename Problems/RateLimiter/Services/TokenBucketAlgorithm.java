package Low_Level_Design.Problems.RateLimiter.Services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.RateLimiter.models.AlgoConfig;
import Low_Level_Design.Problems.RateLimiter.models.Bucket;
import Low_Level_Design.Problems.RateLimiter.models.Request;
import Low_Level_Design.Problems.RateLimiter.models.Response;
import Low_Level_Design.Problems.RateLimiter.models.TokenBucketConfig;

public class TokenBucketAlgorithm implements EndPointAlgorithm{

    Map<String, Bucket> clientBucket;
    TokenBucketConfig config;

    public TokenBucketAlgorithm(TokenBucketConfig config){
        this.clientBucket = new ConcurrentHashMap<>();

        


    }

    @Override
    public Response isAllowed(Request request) {
        // write the algorithm 

        // return the response

        return null;
       
    }
    
}
