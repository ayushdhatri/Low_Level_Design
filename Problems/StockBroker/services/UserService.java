package Low_Level_Design.Problems.StockBroker.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.StockBroker.models.Account;
import Low_Level_Design.Problems.StockBroker.models.User;

public class UserService implements IUserService {
    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User createUser(String mobNum, String name, Account account) {
        User user = new User(name, mobNum, account);
        return user;

        
    }

    @Override
    public User getUser(String userId) {
        User user = userMap.getOrDefault(userId, null);
        if(null != user){
            throw new IllegalStateException("User not foundd");
        }
        return user;
    }
    
    
}
