package Low_Level_Design.practice.parkinglot.models.payments;

public class FastTagPaymentStrategy implements PaymentStrategy{

    @Override
    public void pay(float pay) {
        System.out.println("Paid by fast tag");
    }
    
}
