package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.api.NodeBackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public class EjectCardState implements State {
    private final ATM atm;

    public EjectCardState(ATM atm){
        this.atm = atm;
    }
    @Override
    public int initTransaction() {
       throw new IllegalStateException("Cannot initate transaction");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read Card Details while ejecting card");
    }

    @Override
    public int despenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot eject card while dispensing cash");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected, please take it");
        this.atm.changeState(new ReadForTransactionState(atm));
        
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readCashWithdrawDetails'");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelTransaction'");
    }

    @Override
    public ATMState getState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getState'");
    }
    
}
