package Low_Level_Design.Problems.StockBroker.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import Low_Level_Design.Problems.StockBroker.enums.OrderSide;
import Low_Level_Design.Problems.StockBroker.enums.OrderType;
import Low_Level_Design.Problems.StockBroker.exceptions.OrderNotFound;
import Low_Level_Design.Problems.StockBroker.models.Order;
import Low_Level_Design.Problems.StockBroker.models.Trade;

public class OrderService implements IOrderService {
    private final Map<String, Order> orderMap = new ConcurrentHashMap<>();// it stores orderId mapped to Order
    private final Map<String, List<Order>>userOrders = new ConcurrentHashMap<>();// it stores userId mapped to list of orders
    private final IStockExchange stockExchange;

    public OrderService(IStockExchange stockExchange){
        this.stockExchange = stockExchange;
    }

    @Override
    public Order createOrder(BigDecimal price, Integer quantity, String userId, String stockId, OrderType orderType, OrderSide orderSide) {
        Order order = new Order(price, quantity, userId, stockId, orderType, orderSide);
        orderMap.put(order.getOrderId(), order);
        userOrders.computeIfAbsent(order.getUserId(), key -> new ArrayList<>()).add(order);
        return order;
    }

    @Override
    public List<Trade> placeOrder(String orderId) {
        // first fetch the order from orderMap
        Order order = orderMap.get(orderId);
        if(order == null){
            throw new OrderNotFound("Order not found with order id: " + orderId);
        }

        List<Trade> trades = stockExchange.matchOrder(order);
        return trades;

        // send this order to stockExchange

        // stock exchange does the orderMatching based on orderType for a stock and return the list of trades


        


        
    }
    
}
