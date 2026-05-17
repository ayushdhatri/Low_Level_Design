package Low_Level_Design.DesignPatterns.StructuralPattern.AdapterPattern;

import Low_Level_Design.DesignPatterns.StructuralPattern.AdapterPattern.LegacySystem.LegacyBillingSystem;
import Low_Level_Design.DesignPatterns.StructuralPattern.AdapterPattern.ModernSystem.ModerPaymentProcessor;

public class Demo {
    public static void main(String[] args) {
        LegacyBillingSystem lbs = new LegacyBillingSystem();
        ModerPaymentProcessor adapter = new LegacyBillingAdapter(lbs);
        adapter.pay(10);
    }
}
