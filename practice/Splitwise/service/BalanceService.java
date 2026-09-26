package Low_Level_Design.practice.Splitwise.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.Splitwise.models.Expense;
import Low_Level_Design.practice.Splitwise.models.Split;
import Low_Level_Design.practice.Splitwise.models.User;

public class BalanceService {
    private final Map<String, Map<String, Double>> balances = new ConcurrentHashMap<>();// for each user, how much 

    public void addExpense(Expense expense){
        User paidBy = expense.getPaidBy();
        String paidById = paidBy.getUserId();
        for(Split split : expense.getSplits()){
            String owedById = split.getUser().getUserId();
            double splitAmount = split.getAmount();

            if(paidById.equals(owedById)){
                continue;// skip self-split
            }

            // update payers perspectvie: owedBy
            updateBalance(paidById, owedById, splitAmount);

            updateBalance(owedById, paidById, -splitAmount);
            
        }
        
    }

    private void updateBalance(String user1, String user2, double splitAmount){
        Map<String, Double> balanceSheet = balances.computeIfAbsent(user1, key -> new HashMap<String, Double>());
        balanceSheet.put(user2, balanceSheet.getOrDefault(user2, 0.0) + splitAmount);
    }

    public void showBalanceForUser(String userId){
        Map<String, Double> balance = balances.getOrDefault(userId, new HashMap<>());
        if(balance == null){
            System.out.println("No balance for user : " + userId);
        }
        for(Map.Entry<String, Double> entry : balance.entrySet()){
            double amount = entry.getValue();
            if(amount > 0){
                System.out.println("User " + entry.getKey() + " owes " + userId + " : " + amount);
            }
            else{
                System.out.println("Users " + userId + " owes " + entry + " : " + amount);
            }
        }
    }




    
}
