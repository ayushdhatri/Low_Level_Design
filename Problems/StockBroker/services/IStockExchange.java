package Low_Level_Design.Problems.StockBroker.services;

import java.util.List;

import Low_Level_Design.Problems.StockBroker.models.Order;
import Low_Level_Design.Problems.StockBroker.models.Trade;

public interface IStockExchange {
    List<Trade> matchOrder(Order order);
    
}
