package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AzureCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;

public class AzureDatabase implements CloudDatabase {
    public void query(String sql) {
        System.out.println("  Executing query on Azure SQL: " + sql);
    }
    public void backup() {
        System.out.println("  Creating Azure SQL backup");
    }
}