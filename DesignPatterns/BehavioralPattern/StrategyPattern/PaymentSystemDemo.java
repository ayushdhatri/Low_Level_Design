package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;


import java.util.*;

public class PaymentSystemDemo{
    public void main(String[] args) {
        // Lets first create few orders
        Order order1 = new Order(1001,299.99, Arrays.asList("Laptop", "Monitor"));
        Order order2 = new Order(1002, 149.99, Arrays.asList("Keyboard"));
        Order order3 = new Order(1003, 499.99, Arrays.asList("Monitor"));
        

        // Process with credit card
        PaymentStrategy creditCardStrategy = new CreditCardPayment();
        PaymentProcessor processor = new PaymentProcessor(creditCardStrategy);
        Map<String, String> cardDetails = new HashMap<>();
        cardDetails.put("card_number", "1234567812345678");
        cardDetails.put("cvv", "123");
        cardDetails.put("expiry", "12/25");

        PaymentResult result1 = processor.processOrderPayment(order1, cardDetails);
        System.out.println("Result: " + result1.getStatus() + "\n");

        // Change strategy to PayPal at runtime
        PaymentStrategy paypalStrategy = new PayPalPayment();
        processor.setPaymentStrategy(paypalStrategy);
        
        Map<String, String> paypalDetails = new HashMap<>();
        paypalDetails.put("email", "customer@example.com");
        
        PaymentResult result2 = processor.processOrderPayment(order2, paypalDetails);
        System.out.println("Result: " + result2.getStatus() + "\n");

    }
    
}