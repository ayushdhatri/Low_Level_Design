package Low_Level_Design.Problems.StockBroker.exceptions;

public class InsufficientFunds extends RuntimeException {

    public InsufficientFunds(String messageString){
        super(messageString);
    }
    
}
