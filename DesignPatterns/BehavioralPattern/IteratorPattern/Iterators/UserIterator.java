package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Iterators;

import java.util.List;

import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Repositories.UserRepository;
import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Repositories.UserRepositoryImpl;

public class UserIterator implements Iterator<List<String>> {
    private UserRepository userRepository;
    private int limit = 1;
    private int offset = 0;
    private List<String> current;
    public UserIterator(int limit){
        this.userRepository = new UserRepositoryImpl();
        this.limit = limit;
        this.current = userRepository.findUsers(limit,offset);

    }

    @Override
    public boolean hasNext() {
        return !current.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String> result = current;
        this.offset+=limit;
        this.current = userRepository.findUsers(limit, offset);
        return result;
    }
    
    
}
