package Low_Level_Design.practice.TrafficSignal;

import java.util.Map;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;
import Low_Level_Design.practice.TrafficSignal.enums.LightColor;

public class Intersection {
    private final String intersectionId;
    private final Map<Direction, Road> roads;
    private  TrafficSignalController controller;

    public Intersection(String intersectionId, Map<Direction, Road> roads, Map<Direction, Map<LightColor, Integer>> durations) {
        this.intersectionId = intersectionId;
        this.roads = roads;
        // this.controller = new TrafficSignalController(roads, durations);
    }

    public TrafficSignalController getController() {
        return controller;
    }

    public String getIntersectionId() {
        return intersectionId;
    }
    
}
