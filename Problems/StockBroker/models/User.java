package Low_Level_Design.Problems.StockBroker.models;

import java.util.UUID;

public class User {
    private final String userId;
    private String mobNum;
    private String name;
    private final Account account;
  
    
    public User(String name, String mobNum, Account account){
        this.userId = UUID.randomUUID().toString();
        this.mobNum = mobNum;
        this.account = account;
    }

    public String getId(){
        return this.userId;
    }

    public String getMobNum(){
        return this.mobNum;
    }

    public String getName(){
        return this.name;
    }

    public Account getAccount(){
        return this.account;
    }

}
