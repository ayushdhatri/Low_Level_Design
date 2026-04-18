package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public class Amex extends CreditCard implements RefundCompatibleCreditCard{
    public RefundLogic refundAlgorithm;
       @Override
    public void swipeAndPay() {
        System.out.println("Amex card swipe and pay");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Amex Card onlinePayment");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Amex Card tapAndPay");
    }

    @Override
    public void refundAmount() {
       refundAlgorithm.doRefund();
    }
    
    
}
