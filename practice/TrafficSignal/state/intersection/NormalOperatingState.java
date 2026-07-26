package Low_Level_Design.practice.TrafficSignal.state.intersection;

import Low_Level_Design.practice.TrafficSignal.TrafficSignalController;
import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public class NormalOperatingState implements IntersectionState{

    @Override
    public void runPhase(TrafficSignalController controller) {
        controller.executeNormalCycleStep();
    }

    @Override
    public void handleEmergency(TrafficSignalController controller, Direction direction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleEmergency'");
    }

    @Override
    public void handleEmergencyCleared(TrafficSignalController controller) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleEmergencyCleared'");
    }

    @Override
    public String getStateName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStateName'");
    }
    
    
}
