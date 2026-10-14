package Low_Level_Design.Problems.StockBroker.models;

import java.lang.classfile.constantpool.IntegerEntry;
import java.math.BigDecimal;
import java.util.UUID;

public class Trade {
    private final String tradeId;

    private final String orderId;// using order id we can fetch its a buy order or sell order

    private final BigDecimal price;

    private final Integer quantity;

    public Trade(String orderId, BigDecimal price, Integer quantity){
        this.tradeId = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTradeId(){
        return this.tradeId;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

}
