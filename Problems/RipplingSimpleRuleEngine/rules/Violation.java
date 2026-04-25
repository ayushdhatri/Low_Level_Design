package Low_Level_Design.Problems.RipplingSimpleRuleEngine.rules;

public class Violation {
    private String message;
    Violation(String message){
        this.message = message;
    }
    public static Violation of(String message){
        return new Violation(message);
    }
    
}
