package Low_Level_Design.practice.TrafficSignal.observer;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;
import Low_Level_Design.practice.TrafficSignal.enums.LightColor;

public class CentralMonitor implements TrafficObserver {
    @Override
    public void update(int intersectionId, Direction direction, LightColor color) {
        System.out.printf("[MONITOR] Intersection %d: Light for %s direction changed to %s.\n",
                intersectionId, direction, color);
    }
}
