package Low_Level_Design.practice.TrafficSignal.observer;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public class HardwareEmergencySensor implements EmergencySubject {
    private final List<EmergencyObserver> observers;

    public HardwareEmergencySensor() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(EmergencyObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(EmergencyObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyEmergencyDetected(Direction direction) {
        for (EmergencyObserver observer : observers) {
            observer.onEmergencyDetected(direction);
        }
    }

    @Override
    public void notifyEmergencyCleared() {
        for (EmergencyObserver observer : observers) {
            observer.onEmergencyCleared();
        }
    }

    // this class own specific method 
    public void triggerEmergency(Direction direction) {
        System.out.println("\n[HARDWARE SENSOR] Emergency vehicle detected on lane: " + direction);
        notifyEmergencyDetected(direction);
    }

    public void clearEmergency() {
        System.out.println("\n[HARDWARE SENSOR] Emergency vehicle passed. Clearing emergency mode.");
        notifyEmergencyCleared();
    }

}
