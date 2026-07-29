package Low_Level_Design.practice.Elevator;

import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import Low_Level_Design.practice.Elevator.Enums.Direction;
import Low_Level_Design.practice.Elevator.state.ElevatorState;
import Low_Level_Design.practice.Elevator.state.IdleState;

public class Elevator implements Runnable {
    private final int id;
    private AtomicInteger currentFloor;
    private ElevatorState state;
    private volatile boolean isRunning = false;
    private final TreeSet<Integer> upRequests;
    private final TreeSet<Integer> downRequests;

    public Elevator(int id){
        this.id = id;
        this.currentFloor = new AtomicInteger(1);
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>((a, b) -> b-a);
        this.state = new IdleState();
    }
    
    public void setState(ElevatorState state){
        this.state = state;
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
