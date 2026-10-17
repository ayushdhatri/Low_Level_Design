package Low_Level_Design.Problems.RateLimiter.models;

public class Endpoint {
    private String endPoint;
    private AlgoConfig config;

    public Endpoint(String endPoint, AlgoConfig config){
        this.endPoint = endPoint;
        this.config = config;
    }
    
    public String getEndPoint(){
        return this.endPoint;
    }
    
    public AlgoConfig getConfig(){
        return this.config;
    }

}
