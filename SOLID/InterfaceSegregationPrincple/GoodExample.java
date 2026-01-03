
package Low_Level_Design.SOLID.InterfaceSegregationPrincple;


import java.util.*;

// Separate interfaces by functional area
interface ComputeService {
    void startInstance(String instanceId);
    void stopInstance(String instanceId);
    void rebootInstance(String instanceId);
    List<Instance> listInstances();
}

interface StorageService {
    void uploadFile(String bucket, String key, byte[] data);
    byte[] downloadFile(String bucket, String key);
    void deleteFile(String bucket, String key);
    List<String> listBuckets();
}

interface DatabaseService {
    void createTable(String tableName, Schema schema);
    void insertRecord(String table, Record record);
    List<Record> queryRecords(String table, String query);
    void deleteTable(String tableName);
}

interface NotificationService {
    void sendEmail(String to, String subject, String body);
    void sendSMS(String phoneNumber, String message);
    void publishToTopic(String topic, String message);
}

interface MonitoringService {
    List<Metric> getMetrics(String resource);
    void setAlarm(String resource, AlarmConfig config);
    List<Log> getLogs(String resource, Date from, Date to);
}

interface BillingService {
    double getCurrentCost();
    List<BillingRecord> getBillingHistory();
    void setSpendingLimit(double limit);
}

// Client 1: Clean dependencies
class FileUploadService {
    private StorageService storage; // ✅ Only depends on what it uses!
    
    public void uploadUserFile(byte[] data) {
        storage.uploadFile("user-files", UUID.randomUUID().toString(), data);
    }
    
    // ✅ Clear what this service does
    // ✅ Only 4 methods to understand
    // ✅ Changes to billing don't affect this
    // ✅ Easy to mock just StorageService
}

// Client 2: Focused interface
class MonitoringDashboard {
    private MonitoringService monitoring; // ✅ Only monitoring!
    
    public void displayMetrics() {
        List<Metric> metrics = monitoring.getMetrics("web-server");
        display(metrics);
    }
    
    // ✅ No confusion about what operations are available
    // ✅ Testing is simple - mock 3 methods
}

// Client 3: Minimal dependencies
class CostTracker {
    private BillingService billing; // ✅ Only billing!
    
    public void checkBudget() {
        double cost = billing.getCurrentCost();
        if (cost > threshold) {
            alert();
        }
    }
    
    // ✅ Zero coupling to compute/storage/database
    // ✅ Changes in those areas don't trigger recompilation
}

// Full-featured client can use multiple interfaces
class CloudManagementConsole {
    private ComputeService compute;
    private StorageService storage;
    private BillingService billing;
    private MonitoringService monitoring;
    
    // ✅ Explicitly declares what it needs
    // ✅ Can add/remove services independently
}

public class GoodExample {

}