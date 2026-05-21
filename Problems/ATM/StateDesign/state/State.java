package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public interface State {
    int initTransaction();

    boolean readCardDetailsAndPin(Card card);

    int despenseCash(int transactionId);

    void ejectCard();

    boolean readCashWithdrawDetails(int transactionId, int amount);

    ATMState getState();
}
