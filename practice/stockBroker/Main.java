package Low_Level_Design.practice.stockBroker;

import java.time.LocalDateTime;


import Low_Level_Design.practice.stockBroker.publisher.ExchangePublisher;
import Low_Level_Design.practice.stockBroker.publisher.IndianStockExchangePublisher;
import Low_Level_Design.practice.stockBroker.subscribers.StockSubscriber;
import Low_Level_Design.practice.stockBroker.utils.Currency;
import Low_Level_Design.practice.stockBroker.utils.StockSymbol;
import Low_Level_Design.practice.stockBroker.utils.Value;

public class Main {
    public static void main(String[] args){
        ExchangePublisher nse = new IndianStockExchangePublisher("NSE");
        ExchangePublisher bse = new IndianStockExchangePublisher("BSE");

        StockSubscriber s1 = new StockSubscriber();
        nse.subscribe(s1);
        bse.subscribe(s1);

        nse.notify(new Value(Currency.INR, 1000), StockSymbol.GOOGLE, LocalDateTime.now());
        bse.notify(new Value(Currency.INR, 2000), StockSymbol.APPLE , LocalDateTime.now());


    }
}
