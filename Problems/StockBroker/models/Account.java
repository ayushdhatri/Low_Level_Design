package Low_Level_Design.Problems.StockBroker.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

import Low_Level_Design.practice.atmLLD.Exceptions.InsufficientBalanceException;

// for building accounts object we should be builder pattern
// becuase lots of verification and other things are required while creating object
// so using builder pattern is essential
// due to time constraints I am not implementing to
// maybe TODO://

public class Account {
    private final String accountId;
    private BigDecimal funds;
    private BigDecimal blockFunds;
    private ReentrantLock lock;
    private Portfolio portfolio;
    private List<Transaction> transactions;
    private List<Order> activeOrders;


    public Account(){
        this.accountId = UUID.randomUUID().toString();
        this.funds = BigDecimal.ZERO;
        this.blockFunds = BigDecimal.ZERO;
        this.lock = new ReentrantLock();
        this.transactions = new ArrayList<>();
        this.activeOrders = new ArrayList<>();
    }

    public void addOrder(Order order){
        this.activeOrders.add(order);
    }

    public List<Order> getActiveOrders(){
        return this.activeOrders;
    }

    public String getAccountId(){
        return this.accountId;
    }

    public void credit(BigDecimal amount){
        // at each step we need to verify and throw error
        lock.lock();
        try{
            if (amount.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalStateException("Amount cannot be negative");
            }
            this.funds = this.funds.add(amount);
            System.out.println("Accound with id : " + this.accountId + "Credited with amount :" + amount + " successfully");    
        }
        finally{
            lock.unlock();
        }
    }
    public void debit(BigDecimal amount){
        lock.lock();
        try{
            if(this.funds.compareTo(amount) < 0){
                throw new InsufficientBalanceException("Account does not have sufficint balance");
            }
            this.funds = this.funds.subtract(amount);
            System.out.println("Accound with id : " + this.accountId + "debited with amount :" + amount + " successfully");    

        }
        finally{
            lock.unlock();
        }

    }

    public void blockFunds(BigDecimal amount){
        // verify
        // amount reduces from main funds
        // goes to blockfunds'
        this.lock.lock();;
        try{
            if(this.funds.compareTo(amount) < 0){
                throw new InsufficientBalanceException("Account does not have sufficient funds to block! Please deposit");
            }
            this.funds = this.funds.subtract(amount);
            this.blockFunds = this.blockFunds.add(amount);
            System.out.println("Fund of :" + amount + " is blocked successfully");
        }
        finally{
            this.lock.unlock();
        }

    }

    public void releaseFunds(BigDecimal amount){
        this.lock.lock();;
        try{
            if(this.blockFunds.compareTo(amount) < 0){
                throw new InsufficientBalanceException("Account does not have sufficient blocked funds to unblock!");
            }
            this.blockFunds = this.funds.subtract(amount);
            this.funds = this.funds.add(amount);
            System.out.println("Fund of :" + amount + " is  unblocked successfully");
        }
        finally{
            this.lock.unlock();
        }



    }

    public BigDecimal viewBalance(){
        this.lock.lock();
        try{
            return this.funds;
        }
        finally{
            this.lock.unlock();
        }

    }

    public ReentrantLock getLockPerAccount(){
        return this.lock;
    }

    public   List<Transaction> getTransactions(){
        return this.transactions;

    }

    public Portfolio viewUserPortfolio(){
        return this.portfolio;
    }

}
