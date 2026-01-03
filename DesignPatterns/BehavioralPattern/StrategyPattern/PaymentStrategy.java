package Low_Level_Design.DesignPatterns.BehavioralPattern.StrategyPattern;

import java.util.*;

public interface PaymentStrategy {
    /**
     * Validates Payment details
     * @param paymentDetails Map containing payment-specific details
     * @retrun true if valid, false otherwise
     */
    boolean validate(Map<String, String> paymentDetails);
    /**
     * Process the payment
     * @param amount Amount to charge
     * @param PaymentDetails payment-specific details
     * @return PaymentResult with the transacation Details
     */
    PaymentResult processPayment(double amount, Map<String, String> paymentDetails);

    /**
     * Gets the name of the payment method
     * @return Payment method name
     */
    String getPaymentMethodName();



     
}