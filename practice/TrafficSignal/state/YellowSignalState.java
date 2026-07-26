package Low_Level_Design.practice.TrafficSignal.state;

import java.util.Map;

import Low_Level_Design.practice.TrafficSignal.TrafficSignal;
import Low_Level_Design.practice.TrafficSignal.enums.LightColor;

public class YellowSignalState implements SignalState{

    @Override
    public void transitionNext(TrafficSignal signal) {
        signal.setCurrentState(new RedSignalState());
    }

    @Override
    public int getDurationInSeconds(Map<LightColor, Integer> durations) {
       return durations.getOrDefault(LightColor.YELLOW, 10);
    }

    @Override
    public LightColor getColor() {
       return LightColor.YELLOW;
    }

    
    
    
}
