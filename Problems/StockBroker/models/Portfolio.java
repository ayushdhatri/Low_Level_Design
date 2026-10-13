package Low_Level_Design.Problems.StockBroker.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Portfolio {
    private Map<String, List<Holdings>> userStockHoldings;

    public Portfolio(){
        this.userStockHoldings = new ConcurrentHashMap<>();
    }

    public List<Holdings> getHoldings(String stockId){
        return this.userStockHoldings.getOrDefault(stockId, new ArrayList<>());
    }

    public void addStockHoldings(String stockId, List<Holdings> holdings){
        this.userStockHoldings.computeIfAbsent(stockId,key-> new ArrayList()).addAll(holdings);
    }
    
}
