package Low_Level_Design.practice.TrafficSignal;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Low_Level_Design.practice.TrafficSignal.enums.Direction;
import Low_Level_Design.practice.TrafficSignal.enums.LightColor;
import Low_Level_Design.practice.TrafficSignal.observer.EmergencyObserver;
import Low_Level_Design.practice.TrafficSignal.state.GreenSignalState;
import Low_Level_Design.practice.TrafficSignal.state.RedSignalState;
import Low_Level_Design.practice.TrafficSignal.state.intersection.IntersectionState;
import Low_Level_Design.practice.TrafficSignal.state.intersection.NormalOperatingState;

// here we are using mediator pattern
public class TrafficSignalController implements EmergencyObserver {
    private final Map<Direction, Road> roads;
    private final Map<Direction, Map<LightColor, Integer>> signalDurations;
    private final ScheduledExecutorService schedular;

    private IntersectionState currIntersectionState;
    private boolean isNorthSouthActive = true;

    public TrafficSignalController(Map<Direction, Road>roads, Map<Direction, Map<LightColor, Integer>> signMap){
        this.roads = roads;
        this.signalDurations = signMap;
        this.schedular = Executors.newSingleThreadScheduledExecutor();
        this.currIntersectionState = new NormalOperatingState();
    }

    public void start(){
        this.currIntersectionState.runPhase(this);
    }

    public void setIntersectionState(IntersectionState newState){
        this.currIntersectionState = newState;
    }

    public IntersectionState getIntersectionState(){
        return this.currIntersectionState;
    }

    public void executeNormalCycleStep(){
        if(!(currIntersectionState instanceof NormalOperatingState))return;
        if(isNorthSouthActive){
            runPhaseForPair(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, () ->{
                this.isNorthSouthActive = false;

            });
        }
    }

    void runPhaseForPair(Direction g1, Direction g2, Direction r1, Direction r2, Runnable onComplete){
        // A. Set Green Phase immediately
        roads.get(g1).getTrafficSignal().setCurrentState(new GreenSignalState());
        roads.get(g2).getTrafficSignal().setCurrentState(new GreenSignalState());
        roads.get(r1).getTrafficSignal().setCurrentState(new RedSignalState());
        roads.get(r2).getTrafficSignal().setCurrentState(new RedSignalState());

        System.out.println("GREEN PHASE for " + g1 + " & " + g2);
        
        schedular.schedule(()->{
            if(!(currIntersectionState instanceof NormalOperatingState))return;
            roads.get(g1).getTrafficSignal().chnageToNextState();
            roads.get(g2).getTrafficSignal().chnageToNextState();
            System.out.println("YELLOW PHASE for" + g1 + " & " + g2);

            int yellowDuration = getDuration(roads.get(g1), LightColor.YELLOW);
            schedular.schedule(() ->{
                if(!(currIntersectionState instanceof NormalOperatingState)){
                    return;
                }
                roads.get(g1).getTrafficSignal().chnageToNextState();
                roads.get(g2).getTrafficSignal().chnageToNextState();

                onComplete.run();

            }, yellowDuration, TimeUnit.SECONDS);

        }, 0, null);
    }



    
    


    @Override
    public void onEmergencyDetected(Direction direction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onEmergencyDetected'");
    }

    @Override
    public void onEmergencyCleared() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onEmergencyCleared'");
    }

    int getDuration(Road g1, LightColor color){
        return g1.getTrafficSignal().getCurrentState().getDurationInSeconds(signalDurations.get(g1));
    }

    
    
}
