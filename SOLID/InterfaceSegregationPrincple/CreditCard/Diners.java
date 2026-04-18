package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public class Diners extends CreditCard{
       @Override
    public void swipeAndPay() {
        System.out.println("Diners card swipe and pay");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Diners Card onlinePayment");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Diners Card tapAndPay");
    }
    
    
}
