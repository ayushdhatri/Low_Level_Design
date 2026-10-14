package Low_Level_Design.Problems.StockBroker.models;

import java.math.BigDecimal;
import java.util.UUID;

public class Stock {
    private final String stockId;
    private String name;
    private BigDecimal price;
    private String desc;

    public Stock(String name, BigDecimal initialPrice, String desc){
        this.stockId = UUID.randomUUID().toString();
        this.name = name;
        this.price = initialPrice;
        this.desc = desc;
    }

    public String getStockId(){
        return this.stockId;
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public String getDesc(){
        return this.desc;
    }

}
