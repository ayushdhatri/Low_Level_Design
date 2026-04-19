package Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules;

import java.util.Optional;

import Low_Level_Design.Problems.RipplingSimpleRuleEngine.model.Expense;

public class MaxAmountRule implements ExpenseRule {
    private final double maxAmount;
    public MaxAmountRule(double maxAmount){
        this.maxAmount = maxAmount;
    }
    @Override
    public Optional<Violation> check(Expense ex) {
        if(ex.getAmount() > this.maxAmount){
            return Optional.of(Violation.of("Expense amount is greater than the max Amount"));
        }
        return Optional.empty();
    }
}
