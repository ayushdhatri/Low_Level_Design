package Low_Level_Design.Problems.ATM.StateDesign.services;

import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public interface CardManagerService {
    boolean validateCard(Card card, String pin);

    boolean validateWithdrawl(int transactionId, double amount);

    boolean doTransacation(Card card, double amount, int transactionId);

}
