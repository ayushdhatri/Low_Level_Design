package Low_Level_Design.Problems.ATM.StateDesign;

import Low_Level_Design.Problems.ATM.StateDesign.models.ATM;
import Low_Level_Design.Problems.ATM.StateDesign.models.Card;
import Low_Level_Design.Problems.ATM.StateDesign.state.ReadForTransactionState;
import Low_Level_Design.Problems.ATM.StateDesign.state.State;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to SBI ATM");

        // we need atm, its initial state
        ATM atm = new ATM("123");// even if we intitalise the atm it is in readyForTransactionPhase
        Card sbiDebitCard = new Card(123455123123L, 1234, "Ayush","DEBIT" null, "SBI");
        System.out.println(atm.getAtmState());
        atm.getAtmState().initTransaction();// here we intiated the transaction



    }
}
