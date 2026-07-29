package Low_Level_Design.practice.Elevator.state;

import Low_Level_Design.practice.Elevator.Elevator;
import Low_Level_Design.practice.Elevator.Enums.Direction;
import Low_Level_Design.practice.Elevator.model.Request;

public interface ElevatorState {
   void move(Elevator elevator);
   void addRequest(Elevator elvator, Request request);
   Direction getDirection(); 
}

