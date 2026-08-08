package Low_Level_Design.practice.PUBSUBSystem.subscriber;

import Low_Level_Design.practice.PUBSUBSystem.entities.Message;

public interface Subsriber {
    String getId();
    void update(Message message);
    
}
