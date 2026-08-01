package Low_Level_Design.practice.Elevator.strategy;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import Low_Level_Design.practice.Elevator.Elevator;
import Low_Level_Design.practice.Elevator.Enums.Direction;
import Low_Level_Design.practice.Elevator.model.Request;

public class NearestSelectionStrategy implements ElevatorSelectionStrategy {

    @Override
    public Optional<Elevator> selectElevator(List<Elevator> elevators, Request request) {
        // we should choose one in which is near to floor that request
        // this request will be external only
        // cases:
        // case 1: Request.Direction = UP: all elevators which are coming towareds me choose one which is having nearest distnace, if there are no elevators, lower then this floor then in that case choose the own which is coming down, if now down all are going up then in that case choose the one  
        // 
        // case 2: Request.Direction = DOWN && Elevator.Direction = UP
        // case 3: Request.Direction = UP && Elevator.Direction = DOWN
        // case 4: Request.Direction = DOWN && Elevator.Direction = DOWN

        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator : elevators){
            if(isSuitable(elevator, request)){
                minDistance = Math.min(minDistance, Math.abs(elevator.getCurrentFloor() - request.getTargetFloor()));
                bestElevator = elevator;
            }
        }
        if(bestElevator == null){
            return Optional.empty();
        }
        return Optional.ofNullable(bestElevator); 
    }

    private boolean isSuitable(Elevator elevator, Request request){
        if(elevator.getDirection() == Direction.IDLE){
            return true;
        }
        if(elevator.getDirection() == request.getDirection()){
            if(request.getDirection() == Direction.UP && elevator.getCurrentFloor() <= request.getTargetFloor()){
                return true;
            }
            if(request.getDirection() == Direction.DOWN && elevator.getCurrentFloor() >= request.getTargetFloor()){
                return true;
            }
        }
        return false;
    }
    
    
}
