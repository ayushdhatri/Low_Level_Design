package Low_Level_Design.practice.stockBroker.publisher;

import java.time.LocalDateTime;

import Low_Level_Design.practice.stockBroker.subscribers.Subscribers;
import Low_Level_Design.practice.stockBroker.utils.StockSymbol;
import Low_Level_Design.practice.stockBroker.utils.Value;

public interface ExchangePublisher {
    void subscribe(Subscribers s);
    void unsubscribe(Subscribers s);
    void notify(Value value,StockSymbol symbol, LocalDateTime timestamp);
}
