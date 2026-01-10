package Low_Level_Design.Problems.ParkingLot.Strategy.PaymentMethods;

public class DebitCardPayment implements PaymentStratergy {
     private String cardNumber;
    public DebitCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card: " + cardNumber);
    }

}
