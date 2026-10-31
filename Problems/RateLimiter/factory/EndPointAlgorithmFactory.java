package Low_Level_Design.Problems.RateLimiter.factory;

import Low_Level_Design.Problems.RateLimiter.Services.EndPointAlgorithm;
import Low_Level_Design.Problems.RateLimiter.Services.TokenBucketAlgorithm;
import Low_Level_Design.Problems.RateLimiter.enums.AlgoType;
import Low_Level_Design.Problems.RateLimiter.models.AlgoConfig;
import Low_Level_Design.Problems.RateLimiter.models.TokenBucketConfig;

public class EndPointAlgorithmFactory {
    public static EndPointAlgorithm createEndPointAlgorithm(AlgoType type,AlgoConfig config){
        switch (type) {
            case AlgoType.TOKEN_BUCKET:
                return new TokenBucketAlgorithm((TokenBucketConfig)config);
            default:
                throw new IllegalStateException("Configuratiosn not found for this type of algorithm");
        }
    }
}

