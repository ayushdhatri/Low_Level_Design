package Low_Level_Design.practice.VendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.VendingMachine.entity.Item;

public class Inventory {
    private final Map<String, Integer> productQuantity;
    private Map<String, Item> productStock;
    
    public Inventory(){
        this.productStock = new ConcurrentHashMap<>();
        this.productQuantity = new ConcurrentHashMap<>();
    }

    public synchronized void addItemToInventory(Item itemToBeAdded, int quantity){
        if(!productStock.containsKey(itemToBeAdded.getCode())){
            // item is already there, just update the quantity
            productStock.put(itemToBeAdded.getCode(), itemToBeAdded);
        }
        productQuantity.put(itemToBeAdded.getCode(), productQuantity.getOrDefault(itemToBeAdded.getCode(), 0) + quantity);
    }

    public boolean hasItem(Item item){
        return productStock.containsKey(item.getCode())
                && productQuantity.getOrDefault(item.getCode(), 0) > 0;
    }

    public synchronized void deductItemFromInventory(Item item){
        if(!hasItem(item)){
            System.out.println("This item is out of stock");
            return;
        }
        // we have to reduce the quantity of a product by 1
        productQuantity.put(item.getCode(), productQuantity.get(item.getCode()) - 1);
    }

    
}
