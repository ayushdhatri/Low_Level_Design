package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.Factory.CardManagerFactory;
import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;
import Low_Level_Design.Problems.ATM.StateDesign.services.CardManagerService;

public class ReadingCashWithdrawlDetails implements State {
    private final ATM atm;
    private final BackendAPI backendAPI;

    public ReadingCashWithdrawlDetails(ATM atm, BackendAPI backendAPI){
        this.atm = atm;
        this.backendAPI = backendAPI;
    }
    @Override
    public int initTransaction() {
       throw new IllegalStateException("Cannot Initiate a new transaction");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card details and pin without inserting card");
    }

    @Override
    public int despenseCash(int transactionId) {
        throw new IllegalStateException(:"Cannot dispense Cash without reading card details and pin");
    }

    @Override
    public void ejectCard() {
       throw new IllegalStateException("Cannot eject card without reading card details and pin");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card,int transactionId, int amount) {
        
        CardManagerService cardManagerService = new CardManagerFactory().getCardManager(card.getCardType());
        boolean isWithdrawlValid = cardManagerService.validateWithdrawl(transactionId, amount);
        if(isWithdrawlValid){


        }
        else{
            this.atm.changeState(new ReadForTransactionState(atm, backendAPI));
        }
    }

    @Override
    public ATMState getState() {
       return ATMState.READING_CASH_WITHDRAW_DETAILS;
    }
    @Override
    public boolean cancelTransaction(int transactionId) {
       this.atm.changeState(new ReadForTransactionState(atm, backendAPI));
       return true;
    }
    
}
