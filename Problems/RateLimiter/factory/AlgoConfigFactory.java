package Low_Level_Design.Problems.RateLimiter.factory;

import java.util.Map;

import Low_Level_Design.Problems.RateLimiter.enums.AlgoConfigParams;
import Low_Level_Design.Problems.RateLimiter.enums.AlgoType;
import Low_Level_Design.Problems.RateLimiter.exceptions.AlgoTypeNotFound;
import Low_Level_Design.Problems.RateLimiter.models.AlgoConfig;
import Low_Level_Design.Problems.RateLimiter.models.TokenBucketConfig;

public class AlgoConfigFactory {
    public static AlgoConfig createAlgoConfig(AlgoType type, Map<String, Integer> params){
        
        switch (type) {
            case AlgoType.TOKEN_BUCKET:
                return new TokenBucketConfig(params.get("capacity"), params.get("refillRatePerSecond"));
            default:
                throw new AlgoTypeNotFound(type.toString());
        }
    }
    
}
