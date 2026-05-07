package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Services;

import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Iterators.Iterator;
import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final Iterator<List<String>> userIterator;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void getusersOnPlatform(){
        /*
         * Here the service layer has to keep track of current offset
         * wheere this pagination is reqd, we need to maintain offset there
         * We dont know when to stop ? we might have to write a custom logic to check if no more data is there
         */
        userRepository.findUsers(10, 1);
    }
    
}
