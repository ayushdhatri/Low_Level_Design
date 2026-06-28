package Low_Level_Design.Problems.PubSub;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Low_Level_Design.Problems.PubSub.entities.Message;
import Low_Level_Design.Problems.PubSub.entities.Topic;
import Low_Level_Design.Problems.PubSub.subscriber.Subscriber;

public class PubSubService {
    private static final PubSubService INSTANCE = new PubSubService();
    private final ExecutorService deliveryExecutor;
    private final Map<String, Topic> topicRegistry;
    

    public PubSubService(){
        this.topicRegistry = new ConcurrentHashMap<>();
        // A cached thread pool is suitable for handling many short-lived, bursty tasks
        deliveryExecutor = Executors.newCachedThreadPool();
    }

    public static PubSubService getInstance(){
        return INSTANCE;
    }

    public void registerTopic(String topicName){
        Topic newTopic = new Topic(topicName, deliveryExecutor);
        topicRegistry.putIfAbsent(topicName, newTopic);
    }

    public void subscribe(String topicName, Subscriber subscriber){
        if(!topicRegistry.containsKey(topicName)){
            throw new IllegalArgumentException("Topic with name : " + topicName + " does not exist");
        }
        Topic topic = topicRegistry.get(topicName);
        topic.addSubscriber(subscriber);
        
    }

    public void unsubscribe(String topicName, Subscriber subscriber){
              Topic topic = topicRegistry.get(topicName);
        if (topic != null)
            topic.removeSubscribers(subscriber);
        System.out.println("Subscriber '" + subscriber.getId() + "' unsubscribed from topic: " + topicName);
    }

    public void publish(String topicName, Message message){
        Topic topic = topicRegistry.get(topicName);
        if(topic == null){
            throw new IllegalArgumentException("Topic with name : " + topicName + " does not exist");
        }
        topic.broadcast(message);
    }

    public void shutdown(){
        System.out.println("PubSubService Shutting down...");
        deliveryExecutor.shutdown();
        try{
            if(!deliveryExecutor.awaitTermination(60, TimeUnit.SECONDS)){
                deliveryExecutor.shutdownNow();
            }
        }
        catch(InterruptedException ex){
            deliveryExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }



    
    
}
