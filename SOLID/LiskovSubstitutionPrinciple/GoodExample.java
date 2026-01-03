
package Low_Level_Design.SOLID.LiskovSubstitutionPrinciple;

import java.util.*;

public class GoodExample {
    
}

// Define separate abstractions for different capabilities
interface DataStore {
    void connect();
    void close();
}

interface QueryableDataStore extends DataStore {
    ResultSet executeQuery(String sql);
}

interface TransactionalDataStore extends DataStore {
    Transaction beginTransaction();
}

interface Transaction {
    void commit();
    void rollback();
}

class MySQLConnection implements QueryableDataStore, TransactionalDataStore {
    private Connection connection;
    
    @Override
    public void connect() {
        // MySQL connection
    }
    
    @Override
    public ResultSet executeQuery(String sql) {
        return statement.executeQuery(sql);
    }
    
    @Override
    public Transaction beginTransaction() {
        connection.setAutoCommit(false);
        return new MySQLTransaction(connection);
    }
    
    @Override
    public void close() {
        connection.close();
    }
}

class RedisConnection implements DataStore {
    private Jedis redis;
    
    @Override
    public void connect() {
        // Redis connection
    }
    
    public String get(String key) {
        return redis.get(key);
    }
    
    public void set(String key, String value) {
        redis.set(key, value);
    }
    
    @Override
    public void close() {
        redis.close();
    }
    
    // Redis has its own API, not forcing SQL interface
}

// Client code uses appropriate interfaces
class UserRepository {
    private QueryableDataStore sqlStore;
    private RedisConnection cacheStore;
    
    void transferUserData(User user) {
        // Use SQL store for queries
        if (sqlStore instanceof TransactionalDataStore) {
            TransactionalDataStore txStore = (TransactionalDataStore) sqlStore;
            Transaction tx = txStore.beginTransaction();
            
            try {
                ResultSet rs = sqlStore.executeQuery(
                    "SELECT * FROM users WHERE id = " + user.getId()
                );
                // Process results
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
        }
        
        // Use Redis for caching with its native API
        cacheStore.set("user:" + user.getId(), user.toJson());
    }
}