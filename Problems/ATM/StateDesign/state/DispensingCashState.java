package Low_Level_Design.Problems.ATM.StateDesign.state;

import Low_Level_Design.Problems.ATM.StateDesign.Factory.CardManagerFactory;
import Low_Level_Design.Problems.ATM.StateDesign.api.BackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.api.NodeBackendAPI;
import Low_Level_Design.Problems.ATM.StateDesign.enums.ATMState;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;
import Low_Level_Design.Problems.ATM.StateDesign.services.CardManagerService;
import Low_Level_Design.Problems.ATM.StateDesign.services.CashDispenserService;
import Low_Level_Design.Problems.ATM.StateDesign.services.CashDispenserServiceImpl;

public class DispensingCashState implements State {
    private final ATM atm;
    private final BackendAPI backendAPI;
    private final CashDispenserService cashDispenserService;

    public DispensingCashState(ATM atm) {
        this.atm = atm;
        this.backendAPI = new NodeBackendAPI();
        this.cashDispenserService = new CashDispenserServiceImpl(backendAPI);
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
    public int despenseCash(Card card,int amount,int transactionId) {
           CardManagerService manager = CardManagerFactory.getCardManager(card.getCardType());
           boolean isTxnSuccessfull = manager.doTransacation(card, amount, transactionId);
           if(isTxnSuccessfull)
           {
                cashDispenserService.dispenseCash(atm, amount);
                this.atm.changeState(new EjectCardState(atm));
           }
           else{
                System.out.println("Something went wrong");
                this.atm.changeState(new ReadCardDetailsAndPinState(atm));
           }
           return  amount;


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
