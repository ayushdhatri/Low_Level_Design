package Low_Level_Design.Problems.StockBroker.models;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {
    private final String txnId;

    private final BigDecimal amount;

    private final String fromAccountId;

    private final String toAccountId;

    public Transaction(BigDecimal amount, String fromAccountId, String toAccountId){
        this.txnId = UUID.randomUUID().toString();
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
    }

    public String getTxnId(){
        return this.txnId;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public String getFromAccountId(){
        return this.fromAccountId;
    }

    public String getToAccountId(){
        return this.toAccountId;
    }
    
    
}
