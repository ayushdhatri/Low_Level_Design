

package Low_Level_Design.Problems.VendingMachine.entity;

import java.util.HashMap;
import java.util.Map;



public class Inventory {
    private final Map<String,Item> itemMap = new HashMap<>();
    private final Map<String, Integer> stockMap = new HashMap<>();
    
    public void addItem(String code, Item item, int quantity){
        itemMap.put(code, item);
        stockMap.put(code, quantity);
    }

    public Item getItem(String code){
        return itemMap.get(code);
    }

    public boolean isAvailable(String code){
        if(stockMap.get(code)> 0){
            return true;
        }
        return false;
    }
    public void reduceStock(String code) {
        stockMap.put(code, stockMap.get(code) - 1);
    }



    
}