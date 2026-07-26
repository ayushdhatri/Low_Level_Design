package Low_Level_Design.practice.TrafficSignal;

import java.util.Map;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public class Intersection {
    private final String intersectionId;
    private final Map<Direction, Road> roads;
    private final TrafficSignalController controller;
    
}
