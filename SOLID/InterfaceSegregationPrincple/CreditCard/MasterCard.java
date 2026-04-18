package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public class MasterCard extends CreditCard implements RefundCompatibleCreditCard{
    public RefundLogic refundAlgorithm;
    @Override
    public void swipeAndPay() {
        System.out.println("MasterCard card swipe and pay");
    }

    @Override
    public void tapAndPay() {
        System.out.println("MasterCard Card onlinePayment");
    }

    @Override
    public void onlinePayment() {
        System.out.println("MasterCard Card tapAndPay");
    }
     @Override
    public void refundAmount() {
       refundAlgorithm.doRefund();
    }
    
    
}
