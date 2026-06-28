package Low_Level_Design.Problems.PubSub.subscriber;

import Low_Level_Design.Problems.PubSub.entities.Message;

public interface Subscriber {
    public String getId();
    void onMessage(Message message);
    
} 
