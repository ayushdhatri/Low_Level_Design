package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;
import java.util.*;
class Transaction {
    private final int orderId;
    private final String transactionId;
    private final double amount;
    private final String paymentMethod;
    
    public Transaction(int orderId, String transactionId, double amount, String paymentMethod) {
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    
    public int getOrderId() { return orderId; }
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    
    @Override
    public String toString() {
        return String.format("Order: %d | Transaction: %s | Amount: $%.2f | Method: %s",
                           orderId, transactionId, amount, paymentMethod);
    }
}

