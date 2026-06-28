package Low_Level_Design.Problems.crickbuzz.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import Low_Level_Design.Problems.crickbuzz.model.Match;
import Low_Level_Design.Problems.crickbuzz.subscribers.ScoreBoardSubscriber;
import Low_Level_Design.Problems.crickbuzz.subscribers.Subscriber;

public class ICCScoreProducer implements Producer
 {
    Match match;
    private Set<Subscriber> subscribers;
    ICCScoreProducer(Match match){
        this.match = match;
        this.subscribers = new CopyOnWriteArraySet<>();
    }

    public void scoreUpdate(String runs, String over, String ball, String wickets, boolean isFirstInnings){
       //this.scoreBoardSubscriber.update(this);
    }

    @Override
    public Match getMatchData() {
        return this.match;
    }

    @Override
    public void subscibe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
        
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber : subscribers){
            subscriber.update(this);
        }
    }

}
