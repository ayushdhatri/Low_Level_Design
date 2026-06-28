package Low_Level_Design.Problems.PubSub.entities;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

import Low_Level_Design.Problems.PubSub.subscriber.Subscriber;

public class Topic {
    private String name;
    private final Set<Subscriber> subscribers;
    private final ExecutorService delExecutor;

    public Topic(String name, ExecutorService deliveryExecutor){
        this.name = name;
        this.delExecutor = deliveryExecutor;
        this.subscribers = new CopyOnWriteArraySet<>();
    }

    public String getName(){
        return this.name;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscribers(Subscriber s){
        subscribers.remove(s);
    }

    public void broadcast(Message message){
        for(Subscriber sub : subscribers){
            delExecutor.submit(() ->{
                try{
                    // call the specifc subsriber with desired message
                    sub.onMessage(message);
                }
                catch (Exception e){
                    System.out.println("Error delivering message to subsriber " + e.getMessage());
                }
            });
        }
    }
}
