package Low_Level_Design.practice.AirlineManagementSystem.strategy;

public class UPIPayment implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {
        // ideal this shoud be a network call 
       System.out.println("Payment done via UPI of amount : " + amount);
       return true;
    }
    
    
}
