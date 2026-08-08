package Low_Level_Design.practice.PUBSUBSystem.entities;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

import Low_Level_Design.Problems.PubSub.subscriber.Subscriber;
import Low_Level_Design.practice.PUBSUBSystem.subscriber.Subsriber;

public class Topic {
    private String topicId;
    
    private String topicName;

    private ExecutorService deliveryExecutor;

    private Set<Subsriber> subscribers;

    public Topic(String id, String name, ExecutorService delService){
        this.topicId = id;
        this.topicName = name;
        this.deliveryExecutor = delService;
        this.subscribers = new CopyOnWriteArraySet<>();
    }

    public void notify(Message message){
        // notify all subsriber about this message
        for(Subsriber sub : subscribers){
           deliveryExecutor.submit(()->{
            try{
                sub.update(message);
            }catch(Exception e){
                System.out.println("Error delivering message to subsriber " + sub.getId());
            }
           });
        }
    }

    public void addSubsriber(Subscriber subscriber){
        // anyways it will contain only unique only, no duplicates
        this.subscribers.add((Subsriber) subscriber);
    }

    public void removeSubscriber(Subsriber subsriber){
        this.subscribers.remove(subsriber);
    }

    public String getTopicName(){
        return this.topicName;
    }

    public String getTopicId(){
        return this.topicId;
    }
}
