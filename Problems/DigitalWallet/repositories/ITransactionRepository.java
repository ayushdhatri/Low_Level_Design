package Low_Level_Design.Problems.DigitalWallet.repositories;

import java.util.List;

import Low_Level_Design.Problems.DigitalWallet.models.Transaction;

public interface ITransactionRepository {
    void save(Transaction transaction);

    List<Transaction> findByAccountId(String accId);
    
}
