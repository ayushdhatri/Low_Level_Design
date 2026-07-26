package Low_Level_Design.practice.TrafficSignal.state.intersection;

import Low_Level_Design.practice.TrafficSignal.TrafficSignalController;
import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public interface IntersectionState {
    void runPhase(TrafficSignalController controller);
    void handleEmergency(TrafficSignalController controller, Direction direction);
    void handleEmergencyCleared(TrafficSignalController controller);
    String getStateName();
}
