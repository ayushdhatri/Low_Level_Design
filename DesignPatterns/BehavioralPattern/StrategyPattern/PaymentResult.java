package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;
import java.util.*;

public class PaymentResult {
     private final String status;
    private final String message;
    private final String transactionId;
    private final double amount;
    private final String paymentMethod;
    
    public PaymentResult(String status, String message, String transactionId, 
                        double amount, String paymentMethod) {
        this.status = status;
        this.message = message;
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    
    public PaymentResult(String status, String message) {
        this(status, message, "", 0.0, "");
    }
    
    public String getStatus() { return status; }
    public String getMessage() { return message; }
    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    
    @Override
    public String toString() {
        return "PaymentResult{status='" + status + "', transactionId='" + transactionId + "'}";
    }

}