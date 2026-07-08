package Low_Level_Design.practice.parkinglot.models.payments;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(float amount) {
        System.out.println("Paid via Card");
    }

    
}
