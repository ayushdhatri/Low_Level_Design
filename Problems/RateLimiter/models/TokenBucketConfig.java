package Low_Level_Design.Problems.RateLimiter.models;

public class TokenBucketConfig implements AlgoConfig {
    private double capacity;
    private double refillRatePerSecond;

    public TokenBucketConfig(double capacity, double refillRatePerSecond){
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
    }

    public double getCapacity(){
        return this.capacity;
    }

    public double getRefilRatePerSecond(){
        return this.refillRatePerSecond;
    }
    


    
}
