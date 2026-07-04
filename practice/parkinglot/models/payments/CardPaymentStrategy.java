package Low_Level_Design.practice.parkinglot.models.payments;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid via Card");
    }

    
}
