package Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules;

import java.util.Optional;

import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.Expense;


public interface ExpenseRule {
    Optional<Violation> check(Expense ex);

}
