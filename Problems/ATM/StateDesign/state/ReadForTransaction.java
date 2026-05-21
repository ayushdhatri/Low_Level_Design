package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.api.NodeBackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public class ReadForTransaction implements State {
    // we need some atm details to intitate the transaction
    // we dont want to intilize the atm here becuase it will create tight coupling so for that purpose we do dependency injection
    private final ATM atm;
    private final NodeBackendAPI atmBackendAPI;

    public ReadForTransaction(ATM atm, NodeBackendAPI atmBackendAPI){
        this.atm = atm;
        this.atmBackendAPI = atmBackendAPI;
    }
    @Override
    public int initTransaction() {
        return this.atmBackendAPI.createTransaction(atm.getAtmId());
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
       throw new IllegalStateException("Cannot read card details without inserting card");
    }

    @Override
    public int despenseCash(int transactionId) {
       throw new IllegalStateException("Cannot Dispense Cash without reading card details");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot Eject Card Without Reading Card Details");
    }

    @Override
    public boolean readCashWithdrawDetails(int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details without reading card details");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_FOR_TRANSACTION;
    }
    
}
