package Low_Level_Design.SOLID.InterfaceSegregationPrincple.CreditCard;

public class SameInstrumentRefund implements RefundLogic {
    @Override
    public void doRefund(){
        System.out.println("Refund done in same instrumenet");
    }
    
}
