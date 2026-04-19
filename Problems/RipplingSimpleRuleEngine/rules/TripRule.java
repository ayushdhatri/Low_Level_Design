package Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules;

import java.util.List;
import java.util.Optional;

import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.Expense;

public interface TripRule {
    Optional<Violation> check(List<Expense> expenses);
    
} 
