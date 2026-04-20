package Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.Expense;

public class TripTotalMaxRule implements TripRule {
    private final double maxAmount;
    private String temp;
    public TripTotalMaxRule(double maxAmount){
        this.maxAmount = maxAmount;
    }
    @Override
    public Optional<Violation> check(List<Expense> expenses) {
        double total = 0;
        for(Expense expense : expenses){
            total+=expense.getAmount();
        }
        if(total > maxAmount){
            return Optional.of(new Violation("Trip total exceeds the maximum amount"));
        }
        return Optional.empty();


        
    }
    
    
}
