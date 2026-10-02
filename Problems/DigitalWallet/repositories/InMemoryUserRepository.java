package Low_Level_Design.Problems.DigitalWallet.repositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.DigitalWallet.models.User;

public class InMemoryUserRepository implements IUserRepository {
    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getUserId(), user);
    }

    @Override
    public User findById(String userId) {
        User user = userMap.get(userId);
        return user;
    }
    
}
