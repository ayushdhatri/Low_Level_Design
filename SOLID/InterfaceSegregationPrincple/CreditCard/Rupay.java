package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public class Rupay extends CreditCard implements RefundCompatibleCreditCard{
        public RefundAlgorithm refundAlgorithm;
       @Override
    public void swipeAndPay() {
        System.out.println("Rupay card swipe and pay");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Rupay Card onlinePayment");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Rupay Card tapAndPay");
    }

    @Override
    public void refundAmount() {
       refundAlgorithm.Algo2();
    }
    
    
}
