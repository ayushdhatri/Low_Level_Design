package Low_Level_Design.practice.PUBSUBSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Low_Level_Design.Problems.PubSub.subscriber.Subscriber;
import Low_Level_Design.practice.PUBSUBSystem.entities.Topic;

public class PubSubService {
    public static final PubSubService INSTANCE = new PubSubService();
    private final Map<String, Topic> topicRegistry;
    private ExecutorService deliveryExecutorService;
    private PubSubService(){
        this.topicRegistry = new ConcurrentHashMap<>();
        this.deliveryExecutorService = Executors.newCachedThreadPool();
    }

    public static PubSubService getInstance(){
        return INSTANCE;
    }

   public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic = topicRegistry.get(topicName);
        if (topic == null)
            throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.addSubsriber(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' subscribed to topic: " + topicName);
    }


    public void shutdown(){
        deliveryExecutorService.shutdown();
        try{
            if(!deliveryExecutorService.awaitTermination(2, TimeUnit.SECONDS)){
                this.deliveryExecutorService.shutdownNow();
            }

        }catch(InterruptedException e){
            deliveryExecutorService.shutdownNow();
            Thread.currentThread().interrupt();;
        }
    }
    

}
