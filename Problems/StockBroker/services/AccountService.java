package Low_Level_Design.Problems.StockBroker.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.StockBroker.models.Account;
import Low_Level_Design.Problems.StockBroker.models.Portfolio;
import Low_Level_Design.Problems.StockBroker.models.Transaction;

public class AccountService implements IAccountService {
    private final Map<String, Account> accountMap = new ConcurrentHashMap<>();

    @Override
    public Account createAccount() {
        Account account = new Account();
        this.accountMap.put(account.getAccountId(), account);
        return account;
        
    }

    @Override
    public Account getAccount(String acccountId) {
        return accountMap.get(acccountId);
    }

    @Override
    public List<Transaction> getTransactionHistory(String accountId) {
        Account account = getAccount(accountId);
        if(null == account){
            throw new IllegalStateException("Account does not exist");
        }
        return account.getTransactions();
        
    }   

    @Override
    public Portfolio getPortfolio(String accountId) {
        Account account = getAccount(accountId);
        if(null == account){
            throw new IllegalStateException("Account does not exist");
        }
        return account.viewUserPortfolio();

       
    }

    @Override
    public BigDecimal viewBalance(String accountId) {
        Account account = getAccount(accountId);
        if(null == account){
            throw new IllegalStateException("Account does not exist");
        }
        return account.viewBalance();
        
    }
    
}
