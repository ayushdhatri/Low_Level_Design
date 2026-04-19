package Low_Level_Design.Problems.RipplingSimpleRuleEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.Expense;
import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.ExpenseType;
import Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules.ExpenseRule;
import Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules.TripRule;
import Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules.Violation;

public class RuleEngine {
    public List<Violation> evaluate(
        List<TripRule> rules, 
        List<Expense> expenses,
        Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry,
        List<ExpenseRule> allExpenseRuleRegistry
    ){
        List<Violation> violationsResult = new ArrayList<>();
        for(Expense expense : expenses){
            List<ExpenseRule> rules1 = expenseRulesRegistry.getOrDefault(expense.gExpenseType(), List.of()); 
            for(ExpenseRule rule : rules1){
                Optional<Violation>  violation = rule.check(expense);
                if(violation.isPresent()){
                    violationsResult.add(violation.get());
                }

            }

        }
        return null;

    }
}
