package Low_Level_Design.practice.Splitwise.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.Splitwise.Exception.ResourceNotFound;
import Low_Level_Design.practice.Splitwise.models.Expense;
import Low_Level_Design.practice.Splitwise.models.Group;
import Low_Level_Design.practice.Splitwise.models.Split;
import Low_Level_Design.practice.Splitwise.models.Transaction;

public class SplitwiseService {
    Map<String, Group> groupMap  = new ConcurrentHashMap<>();
    
    public List<Transaction> simplyDebt(String groupId){
        Group group = groupMap.get(groupId);
        if(group == null){
            throw new ResourceNotFound(groupId);
        }
        List<Transaction> transactions;
        Map<String, Double> netBalance = new HashMap<>();
        
        for(Expense expense : group.getAllExpense()){
            String paidBy = expense.getPaidBy().getUserId();

            for(Split split : expense.getSplits()){
                
                
            }
        }





        return transactions;
        
    }

    
}
