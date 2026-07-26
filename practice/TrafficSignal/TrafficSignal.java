package Low_Level_Design.practice.TrafficSignal;

import Low_Level_Design.practice.TrafficSignal.state.RedSignalState;
import Low_Level_Design.practice.TrafficSignal.state.SignalState;

public class TrafficSignal {
    private SignalState state;

    public TrafficSignal(){
        this.state= new RedSignalState();
    }
    public void setCurrentState(SignalState state){
        this.state = state;
    }

    public SignalState getCurrentState(){
        return this.state;
    }
    
    
}
