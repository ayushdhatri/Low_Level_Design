package Low_Level_Design.Problems.DigitalWallet.repositories;

import Low_Level_Design.Problems.DigitalWallet.models.Account;

public interface IAccountRepository {
    void save(Account a);

    Account findById(String id);
    
}
