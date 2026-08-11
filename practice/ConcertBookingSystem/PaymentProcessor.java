package Low_Level_Design.practice.ConcertBookingSystem;

import Low_Level_Design.practice.ConcertBookingSystem.strategy.PaymentStrategy;

public class PaymentProcessor {
    public boolean processPayment(PaymentStrategy strategy, double amount){
        return strategy.pay(amount);
    }
}
