package Low_Level_Design.Problems.StockBroker.services;

import java.math.BigDecimal;
import java.util.List;

import Low_Level_Design.Problems.StockBroker.enums.OrderSide;
import Low_Level_Design.Problems.StockBroker.enums.OrderType;
import Low_Level_Design.Problems.StockBroker.models.Order;
import Low_Level_Design.Problems.StockBroker.models.Trade;

public interface IOrderService {
    Order createOrder(BigDecimal price, Integer quantity, String userId, String stockId, OrderType orderType, OrderSide orderSide);

    List<Trade> placeOrder(String orderId);

}
