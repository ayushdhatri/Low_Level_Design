package Low_Level_Design.practice.TrafficSignal.state.intersection;

import Low_Level_Design.practice.TrafficSignal.TrafficSignalController;
import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public class EmergencyOperatingSystem implements IntersectionState {

    @Override
    public void runPhase(TrafficSignalController controller) {
        // Normal phase cycling suspended during emergency
    }

    @Override
    public void handleEmergency(TrafficSignalController controller, Direction direction) {
        System.out.println("Already in Emergency state for " + direction);
    }

    @Override
    public void handleEmergencyCleared(TrafficSignalController controller) {
       System.out.println("Here we need to change the emergency state to normal state");
       // to normal operating state
    }

    @Override
    public String getStateName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStateName'");
    }
    
}
