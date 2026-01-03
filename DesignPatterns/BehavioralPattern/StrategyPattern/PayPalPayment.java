package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;

import java.util.*;

class PayPalPayment implements PaymentStrategy {
    
    @Override
    public boolean validate(Map<String, String> paymentDetails) {
        String email = paymentDetails.get("email");
        return email != null && email.contains("@") && email.contains(".");
    }
    
    @Override
    public PaymentResult processPayment(double amount, Map<String, String> paymentDetails) {
        if (!validate(paymentDetails)) {
            return new PaymentResult("failed", "Invalid PayPal email");
        }
        
        String email = paymentDetails.get("email");
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("PayPal account: " + email);
        
        
        String username = email.substring(0, email.indexOf("@"));
        String transactionId = "PP_" + username + "_" + (int)amount;
        
        return new PaymentResult("success", "", transactionId, amount, getPaymentMethodName());
    }
    
    @Override
    public String getPaymentMethodName() {
        return "PayPal";
    }
}
