package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.PaymentMethods;

public class CreditCardPayment implements PaymentStratergy {
    private String cardNumber;
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }

}
