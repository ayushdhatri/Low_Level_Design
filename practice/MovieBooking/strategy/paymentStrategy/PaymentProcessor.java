package Low_Level_Design.practice.MovieBooking.strategy.paymentStrategy;

public class PaymentProcessor {
    public boolean processPayment(PaymentStrategy strategy, double amount) {
        return strategy.pay(amount);
    }
}
