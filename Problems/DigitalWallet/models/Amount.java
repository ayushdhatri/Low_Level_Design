package Low_Level_Design.Problems.DigitalWallet.models;

import java.math.BigDecimal;

import Low_Level_Design.Problems.DigitalWallet.enums.Currency;


public class Amount {
    private final BigDecimal value;
    private final Currency currency;

    public Amount(BigDecimal value, Currency currency){
        if(value.signum() < 0){
            throw new IllegalArgumentException("Amount cannot be negative!");
        }
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue(){
        return this.value;
    }

    public Currency getCurrency(){
        return this.currency;
    }

    
}
