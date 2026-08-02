package Low_Level_Design.practice.atmLLD.models;

import Low_Level_Design.practice.atmLLD.service.Account;

public class Card {
    private final String cardNumber;
    private final String pin;
    private final Account account;

    public Card(String cardNumber, String pin, Account account){
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public Account getAccount() {
        return account;
    }

    public boolean validatePin(String pin){
        if(this.pin.equals(pin))return true;
        return false;
    }
    
}
