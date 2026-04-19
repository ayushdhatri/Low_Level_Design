package Low_Level_Design.Problems.RipplingSimpleRuleEngine.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.ExpenseType;
import Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules.DisallowRule;
import Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules.ExpenseRule;
// generally registry class for configuring something like something mapping
// you might be thinking whenever we need to add any new rule then every time we have to modify the class
// but in true sense in large scaled application what happens is all this configuration are stored in database,
// so this registry class is created on run-time
import Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules.MaxAmountRule;

public class RuleRegistry {
    public static void getExpenseRuleRegistry() {
        Map<ExpenseType, List<ExpenseRule>> registry = new HashMap();
        registry.put(ExpenseType.RESTRAUNT, List.of(
            new DisallowRule(),
            new MaxAmountRule(75)
        ));
        registry.put(ExpenseType.AIRFARE, List.of(new DisallowRule()));
    }
    public static List<MaxAmountRule> getAllExpenseRulesRegistry(){
        List<ExpenseRule> registry = new ArrayList<>();
        return List.of(
            new MaxAmountRule(200)
        );



    }
    
}
