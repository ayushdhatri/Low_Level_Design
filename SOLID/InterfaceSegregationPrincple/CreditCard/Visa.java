package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public class Visa extends CreditCard implements RefundCompatibleCreditCard{
    public RefundAlgorithm refundAlgorithm;
    @Override
    public void swipeAndPay() {
        System.out.println("Visa card swipe and pay");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Visa Card onlinePayment");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Visa Card tapAndPay");
    }
    
     @Override
    public void refundAmount() {
       refundAlgorithm.Algo1();
    }
}
