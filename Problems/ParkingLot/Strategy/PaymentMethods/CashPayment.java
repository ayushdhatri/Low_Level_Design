package Low_Level_Design.Problems.ParkingLot.Strategy.PaymentMethods;

public class CashPayment implements PaymentStratergy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}
