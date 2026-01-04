package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AWSCloudProvider.AWSCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AWSCloudProvider.AWSDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AWSCloudProvider.AWSStorage;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;

public class AWSFactory implements CloudServiceFactory{

    @Override
    public CloudStorage createStorage() {
        return new AWSStorage();
    }
    @Override
    public CloudCompute createCompute() {
       return new AWSCompute();
    }

    @Override
    public CloudDatabase createDatabase() {
       return new AWSDatabase();
    }

}