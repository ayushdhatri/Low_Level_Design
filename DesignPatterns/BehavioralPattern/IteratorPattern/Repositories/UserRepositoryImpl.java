package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Repositories;

import java.util.List;

import Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.InMemoryDatabase;

public class UserRepositoryImpl implements UserRepository {
    private InMemoryDatabase db;
    @Override
    public List<String> findUsers(int limit, int offset) {
       List<String> allUsers = db.getUsers();
       int start = (offset -1) * limit;
       int end = Math.min(start + limit, allUsers.size());
       if(start >= allUsers.size()){
        return List.of();
       }
       return allUsers.subList(start, end);
       
    }
    
    
}
