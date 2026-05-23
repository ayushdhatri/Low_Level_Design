package Low_Level_Design.Problems.ATM.StateDesign.state;

import javax.management.RuntimeErrorException;

import Low_Level_Design.Problems.ATM.StateDesign.DTO.CreateTransactionRequestDTO;
import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.api.NodeBackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;

public class ReadForTransactionState implements State {
    // we need some atm details to intitate the transaction
    // we dont want to intilize the atm here becuase it will create tight coupling so for that purpose we do dependency injection
    private final ATM atm;// this is having the details of atm, which want to start the transaction
    private final BackendAPI atmBackendAPI;// we have convert this to interface so that DI is followed

    public ReadForTransactionState(ATM atm, BackendAPI atmBackendAPI){
        this.atm = atm;
        this.atmBackendAPI = atmBackendAPI;
    }
    @Override
    public int initTransaction() {
        // we should create DTO and then pass it
        CreateTransactionRequestDTO createTransactionDTO = new CreateTransactionRequestDTO(this.atm.getAtmId());
        int txnId = this.atmBackendAPI.createTransaction(createTransactionDTO);
        if(txnId == 0){
            throw new RuntimeException("Transaction could not be created");
        }
        // now that we have the transaction id from the backend we should move the atm to the next state
        // also when you change state, your bank server should also be in sync that state has been changed
        // so we need api

        this.atm.changeState(new ReadCardDetailsAndPinState(atm, atmBackendAPI));
        return txnId;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
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
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdraw details without reading card details");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_FOR_TRANSACTION;
    }
    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel a transaction before starint it");
    }
    
}
