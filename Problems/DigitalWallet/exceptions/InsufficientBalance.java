package Low_Level_Design.Problems.DigitalWallet.exceptions;

public class InsufficientBalance extends RuntimeException {
    public InsufficientBalance(String message){
        super(message);
    }
    
}
