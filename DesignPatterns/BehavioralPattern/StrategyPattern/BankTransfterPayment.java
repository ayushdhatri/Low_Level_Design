package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;

import java.util.*;

class BankTransferPayment implements PaymentStrategy {
    
    @Override
    public boolean validate(Map<String, String> paymentDetails) {
        String accountNumber = paymentDetails.get("account_number");
        String routingNumber = paymentDetails.get("routing_number");
        
        if (accountNumber == null || routingNumber == null) {
            return false;
        }
        
        return accountNumber.length() >= 8 && routingNumber.length() == 9;
    }
    
    @Override
    public PaymentResult processPayment(double amount, Map<String, String> paymentDetails) {
        if (!validate(paymentDetails)) {
            return new PaymentResult("failed", "Invalid bank account details");
        }
        
        String accountNumber = paymentDetails.get("account_number");
        System.out.println("Processing bank transfer of $" + amount);
        System.out.println("Account: ****" + accountNumber.substring(accountNumber.length() - 4));
        
       
        String transactionId = "BT_" + accountNumber.substring(accountNumber.length() - 4) 
                              + "_" + (int)amount;
        
        return new PaymentResult("success", "", transactionId, amount, getPaymentMethodName());
    }
    
    @Override
    public String getPaymentMethodName() {
        return "Bank Transfer";
    }
}