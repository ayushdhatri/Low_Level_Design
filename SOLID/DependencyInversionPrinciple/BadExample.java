package Low_Level_Design.SOLID.DependencyInversionPrinciple;
import java.util.*;
public class BadExample {
    
}
class MySQLDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class UserService {
    private MySQLDatabase database;  // Direct dependency on concrete class
    
    public UserService() {
        this.database = new MySQLDatabase();  // Tight coupling
    }
    
    public void saveUser(User user) {
        database.save(user.toString());
    }
}
// Switching to PostgreSQL requires changing UserService