package Low_Level_Design.DesignPatterns.StructuralPattern.AdapterPattern.LegacySystem;

public class LegacyBillingSystem {
    public void chargeAmount(double cents){
        System.out.println("Charged " + cents + " cents using legacy system");
    }
}
