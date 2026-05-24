package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.Factory.CardManagerFactory;
import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.api.NodeBackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.enums.CardType;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;
import Low_Level_Design.Problems.ATM.StateDesign.services.CardManagerService;

public class ReadCardDetailsAndPinState implements State{
    private final ATM atm;
    private final BackendAPI backendAPI;

    public ReadCardDetailsAndPinState(ATM atm){
        this.atm = atm;
        this.backendAPI = new NodeBackendAPI();
    }

    @Override
    public int initTransaction() {
        throw new IllegalArgumentException("Cannot init transaction while reading card details and pin");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        // to migrate the state from one to another
        // we need to do 2 things
        // 1. Change the state of atm
        // 2. make an api call to atm bank server
        /*
            if(card.getType() == CardType.CREDIT){
                CardManagerService cardManagerSerivce = new CreditCardManagerService();
            }
            else if(card.getType() == CardType.DEBIT){
                CardManagerService cardManagerSerivce = new DebitCardManagerService();
            }
            This violates OCP
            and lets say tommorow if constructor of this changes then we need to modify this class
            so it VIOLATES 
            Since we are involved here in creating the objects
            so we should be using factory pattern to solve this
         */

        CardManagerService cardManagerService = CardManagerFactory.getCardManager(card.getCardType());
        boolean isCardValid = cardManagerService.validateCard(card, pin);
        if(isCardValid){
            this.atm.changeState(new ReadingCashWithdrawlDetails(this.atm, this.backendAPI));
        }   
        else{
            this.atm.changeState(new ReadForTransactionState(atm));
        }
        return isCardValid;
    }

    @Override
    public int despenseCash(Card card,int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash while reading card details and pin");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("You cannot eject card while reading details and pin");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawl details while reading card details");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        this.atm.changeState(new ReadForTransactionState(atm));
        return true;
    }
    
}
