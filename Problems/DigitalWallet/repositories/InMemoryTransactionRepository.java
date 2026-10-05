package Low_Level_Design.Problems.DigitalWallet.repositories;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.Problems.DigitalWallet.models.Transaction;

public class InMemoryTransactionRepository implements ITransactionRepository {
    private final Map<String, Transaction> accountMap = new ConcurrentHashMap<>();

    @Override
    public void save(Transaction transaction) {
        this.accountMap.put(transaction.getId(), transaction);
    }

    @Override
    public List<Transaction> findByAccountId(String accId) {
        List<Transaction> transactions = accountMap.values().stream()
                .filter(transaction -> transaction.getFromAcc().equals(accId) || transaction.getToAcc().equals(accId))
                .toList();
        return transactions;
    }

}
