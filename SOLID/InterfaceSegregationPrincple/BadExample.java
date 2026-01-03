package Low_Level_Design.SOLID.InterfaceSegregationPrincple;


import java.util.*;

// One massive interface for all cloud operations
interface CloudService {
    // Compute operations
    void startInstance(String instanceId);
    void stopInstance(String instanceId);
    void rebootInstance(String instanceId);
    List<Instance> listInstances();
    
    // Storage operations
    void uploadFile(String bucket, String key, byte[] data);
    byte[] downloadFile(String bucket, String key);
    void deleteFile(String bucket, String key);
    List<String> listBuckets();
    
    // Database operations
    void createTable(String tableName, Schema schema);
    void insertRecord(String table, Record record);
    List<Record> queryRecords(String table, String query);
    void deleteTable(String tableName);
    
    // Notification operations
    void sendEmail(String to, String subject, String body);
    void sendSMS(String phoneNumber, String message);
    void publishToTopic(String topic, String message);
    
    // Monitoring operations
    List<Metric> getMetrics(String resource);
    void setAlarm(String resource, AlarmConfig config);
    List<Log> getLogs(String resource, Date from, Date to);
    
    // Billing operations
    double getCurrentCost();
    List<BillingRecord> getBillingHistory();
    void setSpendingLimit(double limit);
}
// Client 1: Simple file upload service
class FileUploadService {
    private CloudService cloud;
    
    public void uploadUserFile(byte[] data) {
        // Only needs storage operations
        cloud.uploadFile("user-files", UUID.randomUUID().toString(), data);
    }
    
    // ❌ FORCED to depend on 20+ methods it never uses!
    // ❌ When compute operations change, this class recompiles
    // ❌ Testing requires mocking ALL methods
    // ❌ Documentation is overwhelming - which methods are relevant?
}

// Client 2: Server monitoring dashboard
class MonitoringDashboard {
    private CloudService cloud;
    
    public void displayMetrics() {
        // Only needs monitoring operations
        List<Metric> metrics = cloud.getMetrics("web-server");
        display(metrics);
    }
    
    // ❌ Why does monitoring need to know about database operations?
    // ❌ Why does it depend on email/SMS methods?
    // ❌ Testing is nightmare - mock 20+ irrelevant methods
}

// Client 3: Cost tracking service
class CostTracker {
    private CloudService cloud;
    
    public void checkBudget() {
        // Only needs billing operations
        double cost = cloud.getCurrentCost();
        if (cost > threshold) {
            alert();
        }
    }
    
    // ❌ Depends on compute, storage, database methods for no reason
    // ❌ Changes to any part of CloudService affect this class
}
public class BadExample {

}