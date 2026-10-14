package Low_Level_Design.Problems.StockBroker.exceptions;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String messString){
        super(messString);
    }
}
