package Low_Level_Design.practice.ConcertBookingSystem.strategy;

public class UPIPayment implements PaymentStrategy {
    private final String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("[Payment] Successfully processed $" + amount + " via UPI ID: " + upiId);
        return true;
    }
    
}
