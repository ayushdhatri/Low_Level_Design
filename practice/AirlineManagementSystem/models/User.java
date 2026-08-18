package Low_Level_Design.practice.AirlineManagementSystem.models;

public class User {
    public final String userId, name, email;
    public User(String userId, String name, String email){
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
    public String getUserId(){
        return this.userId;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

}
