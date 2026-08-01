package Low_Level_Design.practice.Elevator.strategy;

import java.util.List;
import java.util.Optional;

import Low_Level_Design.practice.Elevator.Elevator;
import Low_Level_Design.practice.Elevator.model.Request;

public interface ElevatorSelectionStrategy {
    Optional<Elevator> selectElevator(List<Elevator> elevators, Request request);
}
