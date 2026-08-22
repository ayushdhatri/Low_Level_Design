package Low_Level_Design.practice.stockBroker.subscribers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import Low_Level_Design.practice.stockBroker.StockValue;
import Low_Level_Design.practice.stockBroker.utils.StockSymbol;
import Low_Level_Design.practice.stockBroker.utils.Value;

public class StockSubscriber implements Subscribers {
    private final Map<StockSymbol,StockValue> stockData;// in memory data store

    public StockSubscriber(){
        this.stockData = new HashMap<>();
    }

    @Override
    public void update(Value value, StockSymbol symbol, LocalDateTime newTimeStamp) {
        if(!stockData.containsKey(symbol))
        {
            stockData.put(symbol,new StockValue(value, newTimeStamp));
        }
        else if(stockData.get(symbol).getTimestamp().isBefore(newTimeStamp)){
            stockData.put(symbol, new StockValue(value, newTimeStamp));
        }
        else{
            System.out.println("Ignoring old data for stock " + symbol);
        }
        System.out.println("Stock price update for stock with symbol " + symbol + " with listed price as : " + value.getAmount());
            
    }
    
    
}
