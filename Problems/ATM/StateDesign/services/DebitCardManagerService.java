package Low_Level_Design.Problems.ATM.StateDesign.services;

import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public class DebitCardManagerService implements CardManagerService {

    @Override
    public boolean validateCard(Card card, String pin) {
        // Ideally we should make these also connect to api
        return true;
    }

    @Override
    public boolean validateWithdrawl(int txnId, double amount) {
        // Ideally we should make these also connect to api
        return true;
    }

    @Override
    public boolean doTransacation(Card card, double amount, int transactionId) {
       // Ideally we should make these also connect to api
       return true;
    }
    
}
