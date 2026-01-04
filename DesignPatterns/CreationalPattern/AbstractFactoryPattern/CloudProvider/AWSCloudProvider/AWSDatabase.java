package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AWSCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;

public class AWSDatabase implements CloudDatabase {
    public void query(String sql) {
        System.out.println("  Executing query on AWS RDS: " + sql);
    }
    public void backup() {
        System.out.println("  Creating AWS RDS snapshot");
    }
}