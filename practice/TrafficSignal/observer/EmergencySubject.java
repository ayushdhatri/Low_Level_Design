package Low_Level_Design.practice.TrafficSignal.observer;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public interface EmergencySubject {
    void registerObserver(EmergencyObserver observer);
    void removeObserver(EmergencyObserver observer);
    void notifyEmergencyDetected(Direction direction);
    void notifyEmergencyCleared();
}
