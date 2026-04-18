package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public class SameWalletRefund implements RefundLogic {
    @Override
    public void doRefund(){
        System.out.println("Refund done in the same wallet");
    }

}
