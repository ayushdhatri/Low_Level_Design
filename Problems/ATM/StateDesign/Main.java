package Low_Level_Design.Problems.ATM.StateDesign;

import Low_Level_Design.Problems.ATM.StateDesign.enums.CardType;
import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;
import Low_Level_Design.Problems.ATM.StateDesign.models.VisaDebitCard;
import Low_Level_Design.Problems.ATM.StateDesign.state.ReadForTransactionState;
import Low_Level_Design.Problems.ATM.StateDesign.state.State;

public class Main {
    public static void main(String[] args) {
        // Create an atm

        ATM atm = new ATM("ATM-BLR-001");
        Card userCard = new VisaDebitCard(
            9876543210L, 
            1234, 
            "Ayush Solanki", 
            CardType.DEBIT, 
            "HDFC Bank"
        );

        System.out.println("\n========================= STARTING HAPPY PATH TRANSACTION===============");
        try{
            // STEP1 : Initiate Transaction
            System.out.println("Current State : " + atm.getAtmState().getState());
            int transactionId = atm.getAtmState().initTransaction();
            System.out.println("Transaction Initiated. TXN Id : " + transactionId);

            // STEP2 : Read Card and PIN
            System.out.println("Current State : " + atm.getAtmState().getState());olpo0[;;['/io-']]
            boolean isCardValid = atm.getAtmState().readCardDetailsAndPin(userCard, "1234");
            System.out.println("Card validated");

            // STEP3 : Enter Withdrawl Details
            System.out.println("Current State : " + atm.getAtmState().getState());
            int withdrawAmount = 5000;
            boolean isAmountValid = atm.getAtmState().readCashWithdrawDetails(userCard, transactionId, withdrawAmount);


            // STEP4 : Dispense Cash
            System.out.println("Current State: " + atm.getAtmState().getState());
            int dispensed = atm.getAtmState().despenseCash(userCard, withdrawAmount, transactionId);
            System.out.println("Successfully Dispensed: Rs. " + dispensed);

            // STEP 5: Eject Card
            System.out.println("Current State: " + atm.getAtmState().getState());
            atm.getAtmState().ejectCard();

            // Back to initial state!
            System.out.println("Final State: " + atm.getAtmState().getState());
            System.out.println("Hello world");

        }
        catch(Exception ex){
            System.out.println(ex.getMessage() + ex.hashCode());
        }

    }
}
