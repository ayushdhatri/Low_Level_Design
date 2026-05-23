package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public class DispensingCashState implements State {
    private final ATM atm;
    private final BackendAPI backendAPI;

    public DispensingCashState(ATM atm, BackendAPI backendAPI){
        this.atm  = atm;
        this.backendAPI = backendAPI;
    }

    @Override
    public int initTransaction() {
       throw new IllegalStateException("Cannot initiate transaction");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card details while depensing cash");
    }

    @Override
    public int despenseCash(int transactionId) {
        
    }

    @Override
    public void ejectCard() {
       throw new IllegalStateException("Cannot eject card while dispensing cash");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read withdraw details as cash dispensing is in progress");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot Cancel Transaction while dispensing cash");
    }

    @Override
    public ATMState getState() {
        return ATMState.DISPENSING_CASH;
    }
    
    
}
