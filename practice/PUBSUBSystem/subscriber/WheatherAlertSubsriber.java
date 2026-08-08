package Low_Level_Design.practice.PUBSUBSystem.subscriber;

import Low_Level_Design.practice.PUBSUBSystem.entities.Message;

public class WheatherAlertSubsriber implements Subsriber {
    private String id;

    public WheatherAlertSubsriber(String id){
        this.id = id;
    }

    @Override
    public void update(Message message) {
        System.out.println(message.getPayload());
    }
    
    @Override
    public String getId(){
        return this.id;
    }
    
    
}
