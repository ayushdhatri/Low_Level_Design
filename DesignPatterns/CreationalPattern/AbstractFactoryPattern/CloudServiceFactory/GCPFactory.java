package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.GCPCloudProvider.GCPCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.GCPCloudProvider.GCPDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.GCPCloudProvider.GCPStorage;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;

public class GCPFactory implements CloudServiceFactory {
    public CloudStorage createStorage() {
        return new GCPStorage();
    }
    public CloudCompute createCompute() {
        return new GCPCompute();
    }
    public CloudDatabase createDatabase() {
        return new GCPDatabase();
    }
}