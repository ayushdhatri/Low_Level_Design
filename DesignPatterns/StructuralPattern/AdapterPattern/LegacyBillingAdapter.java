package Low_Level_Design.DesignPatterns.StructuralPattern.AdapterPattern;

import Low_Level_Design.DesignPatterns.StructuralPattern.AdapterPattern.LegacySystem.LegacyBillingSystem;
import Low_Level_Design.DesignPatterns.StructuralPattern.AdapterPattern.ModernSystem.ModerPaymentProcessor;

public class LegacyBillingAdapter implements ModerPaymentProcessor {
    LegacyBillingSystem lbs;

    LegacyBillingAdapter(LegacyBillingSystem lbs){
        this.lbs = lbs;
    }

    @Override
    public void pay(int dollars) {
        // here we will right the logic to covert it into way legacy accepts
        double cents = (double) (dollars * 100);
        lbs.chargeAmount(cents);
    }
    
}
