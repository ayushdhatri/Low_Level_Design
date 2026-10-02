package Low_Level_Design.Problems.DigitalWallet.repositories;

import Low_Level_Design.Problems.DigitalWallet.models.User;

public interface IUserRepository {

    void save(User user);

    User findById(String userId);
    
}
