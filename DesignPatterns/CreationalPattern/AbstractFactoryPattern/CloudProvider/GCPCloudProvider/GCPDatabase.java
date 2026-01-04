package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.GCPCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;

public class GCPDatabase implements CloudDatabase {
    public void query(String sql) {
        System.out.println("  Executing query on Google Cloud SQL: " + sql);
    }
    public void backup() {
        System.out.println("  Creating Cloud SQL backup");
    }
}