package Low_Level_Design.SOLID.SingleResponsibility;

import java.util.*;

class UserValidator {
    public void validate(User user) {
        if (user.email == null || !user.email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}

class UserRepository {
    public void save(User user) {
        database.save(user);
    }
}

class EmailService {
    public void sendWelcomeEmail(String email) {
        EmailClient.send(email, "Welcome!", "Thanks for registering");
    }
}

class UserRegistrationService {
    private UserValidator validator;
    private UserRepository repository;
    private EmailService emailService;
    private Logger logger;
    
    public void registerUser(User user) {
        validator.validate(user);
        repository.save(user);
        emailService.sendWelcomeEmail(user.email);
        logger.log("User registered: " + user.email);
    }
}

/*
Each class now has a single, well-defined responsibility
Changes to email logic don't affect validation or persistence
Easier to test each component in isolation
Better code organization and maintainability
 */

public class GoodExample{

}