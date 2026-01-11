package Low_Level_Design.Problems.ParkingLot.CopyDesign.strategy.PaymentMethods;
public class UpiPayment implements PaymentStratergy {
    private String upiId;
    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI: " + upiId);
    }

}
