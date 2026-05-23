package Low_Level_Design.Problems.ATM.StateDesign.services;

import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;

public interface CashDispenserService {
    public void dispenseCash(ATM atm, double amount);
}
