package Low_Level_Design.practice.MovieBooking.strategy.paymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("[Payment] Charged $" + amount + " to Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
        return true;
    }
}
