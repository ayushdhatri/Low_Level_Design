package Low_Level_Design.Problems.DigitalWallet.models;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import Low_Level_Design.Problems.DigitalWallet.enums.Currency;
import Low_Level_Design.Problems.DigitalWallet.exceptions.InsufficientBalance;
import Low_Level_Design.Problems.DigitalWallet.services.strategy.IPaymentMethod;


public class Account {

    private final String accountNumber;

    private final Currency currency;

    private BigDecimal balance;

    List<Transaction> userTransaction;

    private final Map<String, IPaymentMethod> paymentMethods = new ConcurrentHashMap<>();

    private final ReentrantLock lock = new ReentrantLock();

    public Account(String accountNumber, Currency currency ){
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = BigDecimal.ZERO;
        this.userTransaction = new ArrayList<>();
    }

    public void addPaymentMethod(IPaymentMethod pm){
        paymentMethods.put(pm.getId(), pm);
    }
    public void removePaymentMethod(String id) { paymentMethods.remove(id); }
    public IPaymentMethod getPaymentMethod(String id) { return paymentMethods.get(id); }

    public synchronized BigDecimal getBalance(){
     
       
            return this.balance;
    
    }

    public List<Transaction> getAllTransaction(){
        return this.userTransaction;
    }

    public synchronized void credit(BigDecimal amount){
        
        if(amount.signum() < 0){
            throw new IllegalArgumentException("Negative Amount cannot be credited");
        }
        this.balance = this.balance.add(amount);
        System.out.println("Amount Credit successfully");
       
      
    }

    public synchronized void debit(BigDecimal amount){
        // first we need to verify if this is possible or not
      
        if(this.balance.compareTo(amount) >=0){
            this.balance = this.balance.subtract(amount);
        }
        else{
            throw new InsufficientBalance("Insufficinent balance! Cannot debit!");

        }
        
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public Currency getCurrency(){
        return this.currency;
    }

}




    


    

