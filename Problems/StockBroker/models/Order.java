package Low_Level_Design.Problems.StockBroker.models;

import java.math.BigDecimal;
import java.util.UUID;

import Low_Level_Design.Problems.StockBroker.enums.OrderStatus;

// We will be using builder pattern to build the object as we have so many member variable to initialize and need to be validated
// before creating order.
// so builder pattern fits here
// since due to time constraints I am not implmementing it
// if we get some time at the end I am going to implement it

public class Order {
    private final String orderId;

    private final BigDecimal price;

    private final Integer quantity;

    private final String userId;

    private final String stockId;

    private OrderStatus orderStatus;

    public Order(BigDecimal price,Integer quantity, String userId, String stockId){
        this.orderId = UUID.randomUUID().toString();
        this.price = price;
        this.quantity = quantity;
        this.userId = userId;
        this.stockId = stockId;
        this.orderStatus = OrderStatus.PENDING;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public Integer getQuntity(){
        return this.quantity;
    }

    public String getUserId(){
        return this.userId;
    }

    public String getStockId(){
        return this.stockId;
    }

    public OrderStatus getOrderStatus(){
        return this.orderStatus;
    }
}
