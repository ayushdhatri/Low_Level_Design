package Low_Level_Design.Problems.ATM.StateDesign.models;

import Low_Level_Design.Problems.ATM.StateDesign.enums.CardType;

public class VisaDebitCard extends Card implements Visa, Debit {

    public VisaDebitCard(long cardNumber, int pin, String name, CardType cardType, String bankName){
        super(cardNumber, pin, name, cardType, bankName);
    }

    @Override
    public void makePinPayment() {
        this.connectToVisa();
        System.out.println("Making Payment With pin");
    }

    @Override
    public void connectToVisa() {
       System.out.println("Connecting to Visa");
    }
    
}
