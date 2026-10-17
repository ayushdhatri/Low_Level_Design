package Low_Level_Design.Problems.RateLimiter.Services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import JavaDesignPattern.CompositeDesignPattern.DesignPattern.client;
import Low_Level_Design.Problems.RateLimiter.models.AlgoConfig;
import Low_Level_Design.Problems.RateLimiter.models.Bucket;
import Low_Level_Design.Problems.RateLimiter.models.Request;
import Low_Level_Design.Problems.RateLimiter.models.Response;
import Low_Level_Design.Problems.RateLimiter.models.TokenBucketConfig;

public class TokenBucketAlgorithm implements EndPointAlgorithm {

    Map<String, Bucket> clientBucket;
    TokenBucketConfig config;

    public TokenBucketAlgorithm(TokenBucketConfig config) {
        this.clientBucket = new ConcurrentHashMap<>();
        this.config = config;
    }

    @Override
    public Response isAllowed(Request request) {
        LocalDateTime now = LocalDateTime.now();

        Bucket bucket = clientBucket.computeIfAbsent(request.getClientId(),
                key -> new Bucket(config.getCapacity(), now));
        long elapsedSeconds = Duration.between(bucket.getLastRefillTime(), now).getSeconds();


        int tokensToAdd = (int) (elapsedSeconds * config.getRefilRatePerSecond());
        if (tokensToAdd > 0) {
            bucket.setCurrentToken(Math.min(config.getCapacity(),
                    bucket.getCurrentToken() + tokensToAdd));
            bucket.setLastRefillTime(now);
        }

        if (bucket.getCurrentToken() >= 1) {
            bucket.setCurrentToken(bucket.getCurrentToken() - 1);
            return new Response(true, bucket.getCurrentToken(), null);
        }
        // now we will not be able to full fill the request
        double elapseMS = Duration.between(bucket.getLastRefillTime(), now).toMillis();
        LocalDateTime retryAfter = now.plus(Duration.ofMillis((long) (1000 - elapseMS)));
        return new Response(false, 0, retryAfter);

    }

}
