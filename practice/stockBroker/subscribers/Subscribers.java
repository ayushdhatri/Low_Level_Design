package Low_Level_Design.practice.stockBroker.subscribers;

import java.time.LocalDateTime;

import Low_Level_Design.practice.stockBroker.utils.StockSymbol;
import Low_Level_Design.practice.stockBroker.utils.Value;

public interface Subscribers {
    void update(Value value, StockSymbol symbol, LocalDateTime timestamp);
}
