package Low_Level_Design.Problems.StockBroker.services;

import java.math.BigDecimal;
import java.util.List;

import Low_Level_Design.Problems.StockBroker.models.Account;
import Low_Level_Design.Problems.StockBroker.models.Portfolio;
import Low_Level_Design.Problems.StockBroker.models.Transaction;

public interface IAccountService {
    Account createAccount();// creates a default account and return it back
    
    Account getAccount(String acccountId);

    List<Transaction> getTransactionHistory(String accountId);

    Portfolio getPortfolio(String accountId);

    BigDecimal viewBalance(String accountId);
    
    
    
}
