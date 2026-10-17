package Low_Level_Design.Problems.RateLimiter.models;

public class Request {
    private final String  clientId;

    private final String endPoint;

    public Request(String clientId, String endPoint){
        this.clientId = clientId;
        this.endPoint = endPoint;
    }

    public String getClientId(){
        return this.clientId;
    }

    public String getEndPoint(){
        return this.endPoint;
    }
}
