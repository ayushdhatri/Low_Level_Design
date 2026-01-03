package Low_Level_Design.SOLID.DependencyInversionPrinciple;
import java.util.*;
public class GoodExample {
    
}
interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to PostgreSQL: " + data);
    }
}

class UserService {
    private Database database;  // Depends on abstraction
    
    public UserService(Database database) {  // Dependency injection
        this.database = database;
    }
    
    public void saveUser(User user) {
        database.save(user.toString());
    }
}

// Usage
Database db = new PostgreSQLDatabase();
UserService service = new UserService(db);  // Can switch implementations easily