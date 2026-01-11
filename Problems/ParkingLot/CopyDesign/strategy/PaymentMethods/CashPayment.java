package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.PaymentMethods;

public class CashPayment implements PaymentStratergy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}
