package Low_Level_Design.practice.atmLLD.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.atmLLD.Exceptions.InvalidCardException;
import Low_Level_Design.practice.atmLLD.Exceptions.InvalidPinException;
import Low_Level_Design.practice.atmLLD.models.Card;

public class BankService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();
    private final Map<String, Card> cards = new ConcurrentHashMap<>();


    public BankService(){
        Account account1 = createAccount("1234567890", BigDecimal.valueOf(20000));
        Card newCard = createCard("1234-5678-9012-3456", "1234", account1);
    }
    
    public  synchronized Account createAccount(String accountNumber, BigDecimal initialBalance){
        if(accounts.containsKey(accountNumber)){
            // bank account already existt
            throw new IllegalArgumentException("Bank with account Number : " + accountNumber + " already exist");
        }
        Account newAccount = new Account(accountNumber, initialBalance);
        accounts.put(accountNumber, newAccount);
        return newAccount;
    }

    public synchronized Card createCard(String cardNumber, String pin, Account account){
        if(cards.containsKey(cardNumber)){
            throw new IllegalArgumentException("Card with Number : " + cardNumber + " already exist");
        }
        Card newCardWithAccount = new Card(cardNumber, pin, account);
        return newCardWithAccount;
    }

    public Card authenticateCard(String cardNumber, String pin){
        Card card= cards.get(cardNumber);
        if(card == null){
            throw new InvalidCardException("Card not found or invalid.");
        }
        if(!card.validatePin(pin)){
            throw new InvalidPinException("Pin is not correct!Please enter correct pin");
        }
        return card;
    }

    public void processDeposit(String accountNumber, BigDecimal amount){
        // process the transactions
    }
}
