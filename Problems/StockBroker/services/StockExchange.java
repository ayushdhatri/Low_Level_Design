package Low_Level_Design.Problems.StockBroker.services;

import java.util.List;

import Low_Level_Design.Problems.StockBroker.models.Order;
import Low_Level_Design.Problems.StockBroker.models.Trade;

public class StockExchange implements IStockExchange {
    private final Map<String, OrderBook> stockOrderBookMap;

    @Override
    public List<Trade> matchOrder(Order order) {
       
    }
    
    
}
