package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;

public interface CloudServiceFactory {
    CloudStorage createStorage();
    CloudCompute createCompute();
    CloudDatabase createDatabase();
}