package Low_Level_Design.practice.TrafficSignal.observer;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;
import Low_Level_Design.practice.TrafficSignal.enums.LightColor;

public interface TrafficObserver {
    void update(int intersectionId, Direction direction, LightColor color);
}
