package Low_Level_Design.Problems.DigitalWallet.repositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.DigitalWallet.models.Account;

public class InMemoryAccountRespository implements IAccountRepository{
    private final Map<String, Account> accountMap = new ConcurrentHashMap<>();

    @Override
    public void save(Account a) {
        this.accountMap.put(a.getAccountNumber(), a);
    }

    @Override
    public Account findById(String id) {
        return accountMap.get(id);
       
    }
    
    
}
