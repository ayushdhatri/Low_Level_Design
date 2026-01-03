package Low_Level_Design.SOLID.OpenCloseResponsiblity;

import java.util.*;

class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("credit_card")) {
            // Process credit card
            System.out.println("Processing credit card payment: " + amount);
        } else if (paymentType.equals("paypal")) {
            // Process PayPal
            System.out.println("Processing PayPal payment: " + amount);
        } else if (paymentType.equals("crypto")) {
            // Process cryptocurrency
            System.out.println("Processing crypto payment: " + amount);
        }
        // Every new payment method requires modifying this class
    }
}

public class BadExample {
    
    
}
