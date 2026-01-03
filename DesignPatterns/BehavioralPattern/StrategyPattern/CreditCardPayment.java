package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;
import java.util.*;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public boolean validate(Map<String, String> paymentDetails) {
       String cardNumber = paymentDetails.get("card_number");
       String cvv = paymentDetails.get("cvv");
       String expiry = paymentDetails.get("expiry");

       if(cardNumber == null || cvv == null || expiry == null){
            return false;
       }
       return cardNumber.length() == 16 && 
               cvv.length() == 3 && 
               !expiry.isEmpty();
    }

    @Override
    public PaymentResult processPayment(double amount, Map<String, String> paymentDetails) {
        if(!validate(paymentDetails)){
            return new PaymentResult("failed", "Invalid Credit Card Details");
        }
        String cardNumber = paymentDetails.get("card_number");
        System.out.println("Processing Credit Card Paymet of $" + amount);
        System.out.println("Card ending in " + cardNumber.substring(cardNumber.length() - 4));

        String transactionId = "CC_" + cardNumber.substring(cardNumber.length() - 4) 
                              + "_" + (int)amount;
        return new PaymentResult("success", "", transactionId, amount, getPaymentMethodName());
    
      
    }

    @Override
    public String getPaymentMethodName() {
        return "Credit Card";
       
    }
    
}