package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern;

import java.util.ArrayList;
import java.util.List;


public class InMemoryDatabase {
    private List<String> users = new ArrayList<>();
    // those function which populates initial data in your in memory database
    public void seeder(){
        for(int i = 0;i<=2000;i++){
            users.add("User + " + i);
        }
    }

    public List<String> getUsers(){ 
        return users;
    }
    
    
}