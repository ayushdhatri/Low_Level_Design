package Low_Level_Design.Problems.DigitalWallet.services.strategy;

import java.math.BigDecimal;
import java.util.UUID;

import Low_Level_Design.Problems.ATM.StateDesign.models.Credit;

public class CreditCard implements IPaymentMethod{
    private final String id;

    private final String last4Digit;

    public CreditCard(String cardNumber){
        this.id = UUID.randomUUID().toString();
        this.last4Digit = cardNumber.substring(cardNumber.length() - 4);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void charge(BigDecimal amount) {
       // here we make call to make api which transfer the amount to user wallet
        
    }


    
}