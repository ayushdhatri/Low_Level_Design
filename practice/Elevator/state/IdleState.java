package Low_Level_Design.practice.Elevator.state;

import Low_Level_Design.practice.Elevator.Elevator;
import Low_Level_Design.practice.Elevator.Enums.Direction;
import Low_Level_Design.practice.Elevator.model.Request;

public class IdleState implements ElevatorState {

    @Override
    public void move(Elevator elevator) {
        // here we can move either up or down depending on the request
        if(!elevator.getUpRequest().isEmpty()){
            elevator.setState(new MovingUpState());   
        }
        else if(!elevator.getDownRequest().isEmpty()){
            elevator.setState(new DownMovingState());
        }
        //else stay idle

    }

    @Override
    public void addRequest(Elevator elvator, Request request) {
        if(request.getTargetFloor() > elevator.getCurrentFloor()){
            elevator.getUpRequests().add(request.getTargetFloor());
        }
        else if(request.getTargetFloor() > elevator.getCurrentFloor())
        {
            elevator.getDownRequests().add(request.getTargetFloor());
        }

            
    }

    @Override
    public Direction getDirection() {
        return Direction.IDLE;
    }

    
}
