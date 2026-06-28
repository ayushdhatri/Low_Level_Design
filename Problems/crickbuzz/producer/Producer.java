package Low_Level_Design.Problems.crickbuzz.producer;

import Low_Level_Design.Problems.crickbuzz.model.Match;
import Low_Level_Design.Problems.crickbuzz.subscribers.Subscriber;

public interface Producer {
    Match getMatchData();
    public void subscibe(Subscriber subscriber);
    public void unSubscribe(Subscriber subscriber);
    public void notifySubscribers();
    
}

