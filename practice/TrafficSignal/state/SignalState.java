package Low_Level_Design.practice.TrafficSignal.state;

import java.util.Map;

import Low_Level_Design.practice.TrafficSignal.TrafficSignal;
import Low_Level_Design.practice.TrafficSignal.enums.LightColor;

public interface SignalState {
    void transitionNext(TrafficSignal signal);
    int getDurationInSeconds(Map<LightColor,Integer> durations);
    LightColor getColor();
    
}
