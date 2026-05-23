package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public class ReadCardDetailsAndPinState implements State{
    private final ATM atm;
    private final BackendAPI backendAPI;

    public ReadCardDetailsAndPinState(ATM atm, BackendAPI backendAPI){
        this.atm = atm;
        this.backendAPI = backendAPI;
    }

    @Override
    public int initTransaction() {
        throw new IllegalArgumentException("Cannot init transaction while reading card details and pin");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
        // to migrate the state from one to another
        // we need to do 2 things
        // 1. Change the state of atm
        // 2. make an api call to atm bank server

    

        

       
    }

    @Override
    public int despenseCash(int transactionId) {
        throw new IllegalStateException("Cannot dispense cash while reading card details and pin");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("You cannot eject card while reading details and pin");
    }

    @Override
    public boolean readCashWithdrawDetails(int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawl details while reading card details");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }
    
}
