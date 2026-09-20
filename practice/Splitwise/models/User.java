package Low_Level_Design.practice.Splitwise.models;

// user model
// here we can even user builder pattern, but since number of parameter are very less, but in future, if 
// number of variables increase, we can have builder pattern in safe.
public class User {
    private final String userId;

    private final String name;
    
    private String email;

    private final String mobileNumber;

    // we will have getter and setter
    // we can keep member varialbes public to speed up the process of coding to save some time
    // but as of now I am implementing the code completely

    User(String userId, String name, String mobileNumber){
        this.userId = userId;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getMobileNumber(){
        return this.mobileNumber;
    }

    public String getUserId(){
        return this.userId;
    }

    
}
