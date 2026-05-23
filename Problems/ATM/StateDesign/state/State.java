package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public interface State {
    int initTransaction();

    boolean readCardDetailsAndPin(Card card, String pin);// return true if card is valid

    int despenseCash(int transactionId);// returns the amount dispense 

    void ejectCard();

    boolean readCashWithdrawDetails(Card card,int transactionId, int amount);// return true if cash withdrawl details are valid and false otherwise

    boolean cancelTransaction(int transactionId);

    ATMState getState();
}
