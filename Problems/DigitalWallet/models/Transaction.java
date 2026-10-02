package Low_Level_Design.Problems.DigitalWallet.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import Low_Level_Design.Problems.DigitalWallet.enums.TransactionStatus;

public class Transaction {
    private final String id;

    private final String fromAcc;

    private final String toAcc;

    private BigDecimal amount;

    private LocalDateTime createdAt;

    private TransactionStatus status;

    public Transaction(String fromAcc, String toAcc, BigDecimal amount){
        this.id = UUID.randomUUID().toString();
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.status = TransactionStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    public String getId(){
        return this.id;
    }

    public String getFromAcc(){
        return this.fromAcc;
    }

    public String getToAcc(){
        return this.toAcc;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }




}
