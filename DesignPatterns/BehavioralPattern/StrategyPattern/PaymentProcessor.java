package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;


import java.util.*;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    private final List<Transaction> transactionHistory;

    /**
     * Constructor with initital payment strategy
     * @param payment stragety the payment strategy to use
     */
    public PaymentProcessor(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Allow changing the pyamen Strategy at run time
     * @param paymentStrategy to which strategy it should be changed
     */

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

     /**
     * Process payment for an order using the current strategy
     * @param order Order to process
     * @param paymentDetails Payment details
     * @return PaymentResult
     */
    public PaymentResult processOrderPayment(Order order, Map<String, String> paymentDetails) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Processing Order #" + order.getId());
        System.out.println("Amount: $" + order.getAmount());
        System.out.println("Payment Method: " + paymentStrategy.getPaymentMethodName());
        System.out.println("=".repeat(50));
        
        // Delegate to strategy
        PaymentResult result = paymentStrategy.processPayment(order.getAmount(), paymentDetails);
        
        // Log transaction if successful
        if ("success".equals(result.getStatus())) {
            Transaction transaction = new Transaction(
                order.getId(),
                result.getTransactionId(),
                order.getAmount(),
                result.getPaymentMethod()
            );
            transactionHistory.add(transaction);
        }
        
        return result;
    }
    
    /**
     * Get all successful transactions
     * @return List of transactions
     */
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
    
    /**
     * Print transaction history
     */
    public void printTransactionHistory() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("TRANSACTION HISTORY");
        System.out.println("=".repeat(50));
        
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    
}