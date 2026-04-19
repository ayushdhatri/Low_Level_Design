package Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules;

import java.util.Optional;

import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.Expense;

public class DisallowRule implements ExpenseRule {

    @Override
    public Optional<Violation> check(Expense e) {
        return Optional.of(Violation.of("Expesnse type" + e.gExpenseType() + " is not allowed"));
    }
    
    
}
