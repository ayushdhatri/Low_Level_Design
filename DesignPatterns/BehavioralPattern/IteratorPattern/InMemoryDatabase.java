package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

class InMemoryDatabase {
    private List<String> users = new ArrayList<>();

    public void seeder(){
        for(int i = 0;i<=2000;i++){
            users.add("User + " + i);
        }
    }

    public List<String> getUsers(){
        return users;
    }
    
}