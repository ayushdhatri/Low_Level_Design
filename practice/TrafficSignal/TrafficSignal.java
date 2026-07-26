package Low_Level_Design.practice.TrafficSignal;

import Low_Level_Design.practice.TrafficSignal.state.RedSignalState;
import Low_Level_Design.practice.TrafficSignal.state.SignalState;

public class TrafficSignal {
    private final String signalId;
    private SignalState state;

    public TrafficSignal(String id){
        this.signalId = id;
        state = new RedSignalState();// default to red for saftey
    }

    public String getSignalId(){
        return this.signalId;
    }
    public void setCurrentState(SignalState state){
        this.state = state;
    }

    public SignalState getCurrentState(){
        return this.state;
    }

    public void chnageToNextState(){
        this.state.transitionNext(this);
    }

    
}
