package Low_Level_Design.practice.Elevator.state;

import java.net.Authenticator.RequestorType;

import Low_Level_Design.practice.Elevator.Elevator;
import Low_Level_Design.practice.Elevator.Enums.Direction;
import Low_Level_Design.practice.Elevator.Enums.RequestSource;
import Low_Level_Design.practice.Elevator.model.Request;

public class MovingDownState implements ElevatorState{

    @Override
    public void move(Elevator elevator) {
        if(elevator.getDownRequests().isEmpty()){
            elevator.setState(new IdleState());
            return;
        }

        int nextFloor = elevator.getDownRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        if(nextFloor == elevator.getCurrentFloor()){
            System.out.println("Elevator " + elevator.getId() + " Stopped at floor " + nextFloor);
            elevator.getDownRequests().pollFirst();
        }

        if(elevator.getDownRequests().isEmpty()){
            elevator.setState(new IdleState());
        }
    }

    @Override
    public void addRequest(Elevator elvator, Request request) {
        if(request.getSource() == RequestSource.INTERNAL){
            if(request.getTargetFloor() > elvator.getCurrentFloor()){
                elvator.getUpRequests().add(request.getTargetFloor());
            }
            else{
                elvator.getDownRequests().add(request.getTargetFloor());
            }
        }

        if(request.getSource() == RequestSource.EXTERNAL){
            if(elvator.getDirection() == Direction.DOWN && request.getTargetFloor() <= elvator.getCurrentFloor()){
                elvator.getDownRequests().add(request.getTargetFloor());
            }
            else if(request.getDirection() == Direction.UP){
                elvator.getUpRequests().add(request.getTargetFloor());
            }
        }
    }

    @Override
    public Direction getDirection() {
       return Direction.DOWN;
    }
    
    
}
