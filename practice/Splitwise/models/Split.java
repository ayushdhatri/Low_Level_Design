package Low_Level_Design.practice.Splitwise.models;

public class Split {
    private final User user;
    
    private final double amount;

    public Split(User user, double amount){
        this.user = user;
        this.amount = amount;
    }

}
