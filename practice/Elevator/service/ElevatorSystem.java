package Low_Level_Design.practice.Elevator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Low_Level_Design.practice.Elevator.Elevator;
import Low_Level_Design.practice.Elevator.Enums.RequestSource;
import Low_Level_Design.practice.Elevator.model.Request;
import Low_Level_Design.practice.Elevator.observer.ElevatorDisplay;
import Low_Level_Design.practice.Elevator.strategy.ElevatorSelectionStrategy;
import Low_Level_Design.practice.Elevator.strategy.NearestSelectionStrategy;
import Low_Level_Design.practice.TrafficSignal.enums.Direction;

public class ElevatorSystem {
    private static ElevatorSystem INSTANCE;
    private Map<Integer, Elevator> elevators;
    private final ElevatorSelectionStrategy startegy;
    private final ExecutorService executorService;

    private ElevatorSystem(int numElevators){
        this.startegy = new NearestSelectionStrategy();
        this.executorService = Executors.newFixedThreadPool(numElevators);
        List<Elevator> elevatorList = new ArrayList<>();
        ElevatorDisplay elevatorDisplay = new ElevatorDisplay();
        for(int i = 1;i<=numElevators;i++){
            Elevator elevator = new Elevator(i);
            elevator.addObserver(elevatorDisplay);
            elevators.put(i, elevator);
        }
    }

    public static synchronized ElevatorSystem getInstance(int numElevators){
        if(INSTANCE == null){
            return new ElevatorSystem(numElevators);
        }
        return INSTANCE;
    }

    public void start(){
        for(Elevator elevator : elevators.values()){
            executorService.submit(elevator);
        }
    }

    public void requestElevator(int floor, Low_Level_Design.practice.Elevator.Enums.Direction direction) {
        System.out.println("\n>> EXTERNAL Request: User at floor " + floor + " wants to go " + direction);
        Request request = new Request(floor, direction, RequestSource.EXTERNAL);

        // Use strategy to find the best elevator
        Optional<Elevator> selectedElevator = startegy.selectElevator(new ArrayList<>(elevators.values()), request);

        if(selectedElevator.isPresent()) {
            selectedElevator.get().addRequest(request);
        } else {
            System.out.println("System busy, please wait.");
        }
    }

    // INTERNAL Request (Cabin Call)
    public void selectFloor(int elevatorId, int destinationFloor) {
        System.out.println("\n>> INTERNAL Request: User in Elevator " + elevatorId + " selected floor " + destinationFloor);
        Request request = new Request(destinationFloor, Low_Level_Design.practice.Elevator.Enums.Direction.IDLE, RequestSource.INTERNAL);

        Elevator elevator = elevators.get(elevatorId);
        if (elevator != null) {
            elevator.addRequest(request);
        } else {
            System.err.println("Invalid elevator ID.");
        }
    }




}
