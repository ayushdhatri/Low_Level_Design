package Low_Level_Design.practice.PUBSUBSystem.subscriber;

import Low_Level_Design.practice.PUBSUBSystem.entities.Message;

public class NewsAlertSubscriber implements Subsriber {
    private String id;
    public NewsAlertSubscriber(String id){
        this.id = id;
    }
    @Override
    public void update(Message message) {
       // do whatever you want to do with this message
        System.out.println(message.getPayload());
    }

    @Override
    public String getId(){
        return this.id;
    }
    
    
}
