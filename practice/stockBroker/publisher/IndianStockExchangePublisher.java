package Low_Level_Design.practice.stockBroker.publisher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.practice.stockBroker.subscribers.Subscribers;
import Low_Level_Design.practice.stockBroker.utils.StockSymbol;
import Low_Level_Design.practice.stockBroker.utils.Value;

public class IndianStockExchangePublisher implements ExchangePublisher {
    private final List<Subscribers> subscribers;
    private final String exchangeName;


    public IndianStockExchangePublisher(String exchangeName){
        this.exchangeName = exchangeName;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscribers s) {
        subscribers.add(s);
    }

    @Override
    public void unsubscribe(Subscribers s) {
        // TODO Auto-generated method stub
      subscribers.remove(s);
    }

    @Override
    public void notify(Value value, StockSymbol symbol, LocalDateTime timestamp) {
        for(Subscribers subscriber : subscribers){
            subscriber.update(value, symbol, timestamp);
        }
    }
    
    
}
