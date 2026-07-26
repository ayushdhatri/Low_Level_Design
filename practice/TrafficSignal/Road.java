package Low_Level_Design.practice.TrafficSignal;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public class Road {
    private final String roadId;
    private String roadName;// its optional maybe we can set it in the future.
    private final TrafficSignal trafficSignal;
    private final Direction direction;

    public Road(String roadId, Direction direction, TrafficSignal trafficSignal){
        this.direction = direction;
        this.roadId = roadId;
        this.trafficSignal = trafficSignal;
    }

    public void setRoadName(String name){
        this.roadName = name;
    }

    public String getRoadName(){
        return this.roadName;
    }

    public String getRoadId(){
        return this.roadId;
    }

    public TrafficSignal getTrafficSignal(){
        return this.trafficSignal;
    }

    public Direction getDirection(){
        return this.direction;
    }
    

    
}
