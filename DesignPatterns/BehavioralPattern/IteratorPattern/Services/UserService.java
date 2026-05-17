package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Services;

import java.util.List;

import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Iterators.Iterator;
import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Iterators.UserIterator;
import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final Iterator<List<String>> userIterator;
    public UserService(UserRepository userRepository){
        this.userRepository =  userRepository;
        this.userIterator = new UserIterator(10);// lets say tommorow if you want to change iterator simply modify it over here
    }

    public void getusersOnPlatform(){
        /*
         * Before Iterator Pattern
         * Here the service layer has to keep track of current offset
         * wherever  this pagination is reqd, we need to maintain offset there
         * We dont know when to stop ? we might have to write a custom logic to check if no more data is there
         * if you are consuming some part of data you don't know when data is going to end
         */
        while(userIterator.hasNext()){
            List<String> users = userIterator.next();
            System.out.println(users);
            // you are caring about offset, not caring about if data is there or not by custom logic
        }

    }
    
}
