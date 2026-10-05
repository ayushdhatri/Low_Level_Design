package Low_Level_Design.Problems.DigitalWallet.services;

import java.math.BigDecimal;
import java.util.List;

import Low_Level_Design.Problems.DigitalWallet.enums.Currency;
import Low_Level_Design.Problems.DigitalWallet.models.Account;
import Low_Level_Design.Problems.DigitalWallet.models.Transaction;
import Low_Level_Design.Problems.DigitalWallet.repositories.IAccountRepository;
import Low_Level_Design.Problems.DigitalWallet.repositories.ITransactionRepository;
import Low_Level_Design.Problems.DigitalWallet.services.strategy.IPaymentMethod;

public class WalletService {
    private final IAccountRepository accountRepository;
    private final ITransactionRepository transactionRepository;

    public WalletService(IAccountRepository accountRepository, ITransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void addPaymentMethod(String accId, IPaymentMethod paymentMethod) {
        Account account = getAccount(accId);
        if (account == null) {
            throw new IllegalStateException("Account with account Id:" + accId + " does not exist");
        }
        account.addPaymentMethod(paymentMethod);
    }

    public void removePaymentMethod(String accId, String pmId) {
        Account account = getAccount(accId);
        account.removePaymentMethod(pmId);
    }

    private Account getAccount(String accId) {
        Account account = accountRepository.findById(accId);
        return account;
    }

    public void topUp(String accId, String pmId, BigDecimal amount) {
        // get the account details
        // fetch the payment method with required pmId;
        // if payment method does not exist, then throw error
        // else you have the pm
        // initiate a new Transaction
        // debit from paymentMethod
        // credit to accId
        // transaction compltes
        Account account = getAccount(accId);
        if (account == null) {
            throw new IllegalStateException("Account with account Id:" + accId + " does not exist");
        }
        IPaymentMethod pm = account.getPaymentMethod(pmId);
        if (pm == null) {
            throw new IllegalArgumentException("Payment method not found!");
        }

        Transaction txn = new Transaction(null, accId, amount);
        try {
            pm.charge(amount);
            account.credit(amount);
            txn.markSuccess();
        } catch (Exception ex) {
            txn.markFailed();
            throw ex;
        } finally {
            transactionRepository.save(txn);
        }

    }

    public void transferMoney(String fromId, String toId, BigDecimal amount, Currency currency) {
        Account sourceAccount = accountRepository.findById(fromId);
        Account desinationAccount = accountRepository.findById(toId);
        if (sourceAccount == null || desinationAccount == null) {
            throw new IllegalStateException("Either of the account is invalid");
        }
        
        if(sourceAccount.getCurrency() != currency){
            amount = CurrencyConverterService.convert(amount, sourceAccount.getCurrency(), desinationAccount.getCurrency());
        }
        sourceAccount.debit(amount);

        desinationAccount.credit(amount);

        Transaction txn = new Transaction(fromId, toId, amount);
        transactionRepository.save(txn);
        

    }

    public List<Transaction> getTransactions(String accId) {
        getAccount(accId); // throws if the account doesn't exist
        return transactionRepository.findByAccountId(accId);

    }

}
