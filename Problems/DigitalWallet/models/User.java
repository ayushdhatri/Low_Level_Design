package Low_Level_Design.Problems.DigitalWallet.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;

    private String name;

    private String mobNum;

    private Account account;

    // we can also keep if users kyc is done or not but later we can pick if time avails

    public User(String name, String mobNum, Account account){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.mobNum = mobNum;
        this.account = account;
    }

    public String getUserId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getMobNum(){
        return this.mobNum;
    }

    public Account getAccount(){
        return this.account;
    }

    
}
