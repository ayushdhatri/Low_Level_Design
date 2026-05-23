package Low_Level_Design.Problems.ATM.StateDesign.models;

import Low_Level_Design.Problems.ATM.StateDesign.enums.CardType;

public class Card {
    private final long cardNumber;

    private final int pin;

    private final String name;

    private final CardType cardType;

    private final String bankName;

    public Card(long cardNumber, int pin, String name, CardType cardType, String bankName){
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.name = name;
        this.cardType = cardType;
        this.bankName = bankName;
    }

    public long getCardNumber(){
        return this.cardNumber;
    }

    public int getPin(){
        return this.pin;
    }

    public String getName(){
        return this.name;
    }

    public CardType getCardType(){
        return this.cardType;
    }

    public String getBankName(){
        return this.bankName;
    }

    @Override
    public String toString(){
        return "  Card{" + "cardNumber=" + cardNumber + ", pin=" + pin + ", name=" + name + ", cardType=" + cardType;
    }
}
