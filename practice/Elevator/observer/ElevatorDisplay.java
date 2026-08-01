package Low_Level_Design.practice.Elevator.observer;

import Low_Level_Design.practice.Elevator.Elevator;

public class ElevatorDisplay implements ElevatorObserver{

    @Override
    public void update(Elevator elevator) {
        System.out.println("[DISPLAY] Elevator " + elevator.getId() +
                " | Current Floor: " + elevator.getCurrentFloor() +
                " | Direction: " + elevator.getDirection());
    }
    
    
    
}
