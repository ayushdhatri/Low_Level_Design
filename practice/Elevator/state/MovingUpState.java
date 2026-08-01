package Low_Level_Design.practice.Elevator.state;

import Low_Level_Design.practice.Elevator.Elevator;
import Low_Level_Design.practice.Elevator.Enums.Direction;
import Low_Level_Design.practice.Elevator.Enums.RequestSource;
import Low_Level_Design.practice.Elevator.model.Request;

public class MovingUpState implements ElevatorState {

    @Override
    public void move(Elevator elevator) {
        if(elevator.getUpRequests().isEmpty()){
            elevator.setState(new IdleState());
            return;
        }
        Integer nextFloor = elevator.getUpRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        if(elevator.getCurrentFloor() == nextFloor){
            System.out.println("Elevator " + elevator.getId() + " Stopped at floor " + nextFloor);
            elevator.getUpRequests().pollFirst();
        }
        
        if(elevator.getUpRequests().isEmpty()){
            elevator.setState(new IdleState());
        }
    }

    @Override
    public void addRequest(Elevator elvator, Request request) {
        // Internal Requests always get added to the appropriate queue
        if(request.getSource() == RequestSource.INTERNAL){
            if(elvator.getCurrentFloor() < request.getTargetFloor()){
                // request is to go up so add the request inside the uprequest
                elvator.getUpRequests().add(request.getTargetFloor());
            }
            else{
                elvator.getDownRequests().add(request.getTargetFloor());
            }
        }
        // External Request
        if(request.getDirection() == Direction.UP && request.getTargetFloor() >= elvator.getCurrentFloor()){
            elvator.getUpRequests().add(request.getTargetFloor());
        }
        else if(request.getDirection() == Direction.DOWN){
            elvator.getDownRequests().add(request.getTargetFloor());
        }

        
        
    }

    @Override
    public Direction getDirection() {
        return Direction.UP;
    }
    
}
