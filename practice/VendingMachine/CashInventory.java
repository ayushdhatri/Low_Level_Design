package Low_Level_Design.practice.VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Low_Level_Design.practice.VendingMachine.Money.Money;

public class CashInventory {
    private final Map<Money, Integer> cashMap = new HashMap<>();

    public void addMoney(Money money){
        cashMap.put(money,cashMap.getOrDefault(money, 0) + 1);
    }

    public Map<Money, Integer> hasSufficientChange(int changeAmount){
        return calculateChange(changeAmount);
    }

    public Map<Money, Integer> calculateChange(int amount){
        Map<Money, Integer> change = new HashMap<>();
        List<Money> sortedDenominations = new ArrayList<>(cashMap.keySet());
        sortedDenominations.sort((a,b)-> Integer.compare(a.getValue(), b.getValue()));

        int remaining = amount;
        for(Money money : sortedDenominations){
            int available = cashMap.getOrDefault(money, 0);
            int needed = remaining / money.getValue();

            int take = Math.min(available, needed);
            if(take > 0){
                change.put(money, take);
                remaining -=(money.getValue() * take);
            }
        }
        return remaining == 0 ? change : null;

    }

    public void deductChange(Map<Money, Integer> change){
        for(Map.Entry<Money, Integer> entry : change.entrySet()){
            Money deduceMoneyDenomination = entry.getKey();
            int quantity = entry.getValue();
            cashMap.put(deduceMoneyDenomination, cashMap.getOrDefault(deduceMoneyDenomination, 0) - quantity);
        }

    }

    
    
}
