package Low_Level_Design.Problems.PubSub.subscriber;

import Low_Level_Design.Problems.PubSub.entities.Message;

public class NewsSubscriber implements Subscriber {
    private final String id;

    public NewsSubscriber(String id) {
        this.id = id;
    }
    @Override
    public String getId(){
        return this.id;
    }
  
    @Override
    public void onMessage(Message message) {
        System.out.printf("[Subscriber %s] received message '%s'%n", id, message.getPayload());
    }
}