package Low_Level_Design.Problems.RipplingSimpleRuleEngine.model;
// Ideally made using a builder pattern
public class Expense {
    private final String expenseId;
    private final String tripId;
    private final Double amountUSD;
    private final ExpenseType expenseType;

    Expense(String expenseId, String tripId, Double amountUSD, ExpenseType expenseType){
        this.expenseId = expenseId;
        this.tripId = tripId;
        this.amountUSD = amountUSD;
        this.expenseType = expenseType;
    }
    public ExpenseType gExpenseType(){
        return this.expenseType;
    }
    public double getAmount(){
        return this.amountUSD;
    }
    public String getExpenseId(){
        return this.expenseId;
    }
}
