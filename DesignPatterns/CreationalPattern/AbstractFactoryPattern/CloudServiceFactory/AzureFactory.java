package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AzureCloudProvider.AzureCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AzureCloudProvider.AzureDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AzureCloudProvider.AzureStorage;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;

public class AzureFactory implements CloudServiceFactory {
    public CloudStorage createStorage() {
        return new AzureStorage();
    }
    public CloudCompute createCompute() {
        return new AzureCompute();
    }
    public CloudDatabase createDatabase() {
        return new AzureDatabase();
    }
}