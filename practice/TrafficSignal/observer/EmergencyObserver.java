package Low_Level_Design.practice.TrafficSignal.observer;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public interface EmergencyObserver {
    void onEmergencyDetected(Direction direction);
    void onEmergencyCleared();
}
