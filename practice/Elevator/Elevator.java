package Low_Level_Design.practice.Elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import JavaDesignPattern.ChainOfResponsibility.EscalateSystem.Request;
import Low_Level_Design.practice.Elevator.Enums.Direction;
import Low_Level_Design.practice.Elevator.observer.ElevatorObserver;
import Low_Level_Design.practice.Elevator.state.ElevatorState;
import Low_Level_Design.practice.Elevator.state.IdleState;

public class Elevator implements Runnable {
    private final int id;
    private AtomicInteger currentFloor;
    private ElevatorState state;
    private volatile boolean isRunning = false;
    private final TreeSet<Integer> upRequests;
    private final TreeSet<Integer> downRequests;

    List<ElevatorObserver> observers = new ArrayList<>();

    public Elevator(int id){
        this.id = id;
        this.currentFloor = new AtomicInteger(1);
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>((a, b) -> b-a);
        this.state = new IdleState();
    }
    
    public void addObserver(ElevatorObserver observer){
        observers.add(observer);
    }
    public void setState(ElevatorState state){
        this.state = state;
        for(ElevatorObserver observer : observers){
            observer.update(this);
        }
    }
    public void move(){
        state.move(this);
        
    }

    public Direction getDirection(){
        return this.state.getDirection();
    }

    public TreeSet<Integer> getUpRequests(){
        return this.upRequests;
    }

    public TreeSet<Integer> getDownRequests(){
        return this.downRequests;
    }

    public boolean isRuning(){
        return this.isRunning;
    }

    public void stopElevator(){
        this.isRunning = false;
    }

    public int getCurrentFloor(){
        return this.currentFloor.get(); 
    }

    public void setCurrentFloor(int floor){
        this.currentFloor.set(floor);
    }

    public int getId(){
        return this.id;
    }

    public void addRequest(Low_Level_Design.practice.Elevator.model.Request request){
       this.state.addRequest(this, request);
    }

    @Override
    public void run() {
        while(isRunning){
            move();
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }





}
