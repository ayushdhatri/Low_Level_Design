package Low_Level_Design.Problems.StockBroker.services;

import Low_Level_Design.Problems.StockBroker.models.Account;
import Low_Level_Design.Problems.StockBroker.models.User;

public interface IUserService {
    User createUser(String name, String mobNum, Account account);

    User getUser(String userId);

    
    
}
