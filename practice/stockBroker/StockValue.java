package Low_Level_Design.practice.stockBroker;

import java.time.LocalDate;
import java.time.LocalDateTime;

import Low_Level_Design.practice.stockBroker.utils.Value;

/**
 * StockValue
 */
public class StockValue {
    private final Value value;
    private final LocalDateTime timestamp;
    public StockValue(Value value, LocalDateTime timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }

    public Value getValue(){
        return this.value;
    }

    public LocalDateTime getTimestamp(){
        return this.timestamp;
    }
    
}