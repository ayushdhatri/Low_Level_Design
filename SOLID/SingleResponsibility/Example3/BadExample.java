package Low_Level_Design.SOLID.SingleResponsibility;

import java.util.*;

class UserService {
    public void registerUser(User user) {
        // Validate user
        if (user.email == null || !user.email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        
        // Save to database
        database.save(user);
        
        // Send email
        EmailClient.send(user.email, "Welcome!", "Thanks for registering");
        
        // Log the action
        System.out.println("User registered: " + user.email);
    }
}

public class BadExample {
    // above UserSevice you can see that UserService is registering user, validating user, saving to database, sending Email and finally logging.
    // This class has multiple responsibilities - validation, persistence, email sending, and logging. Changes to any of these concerns require modifying this class.
    // ** Note above class has just dummy object of database, EmailClient, not implemented yet. Just for sake of example **
    
    

}