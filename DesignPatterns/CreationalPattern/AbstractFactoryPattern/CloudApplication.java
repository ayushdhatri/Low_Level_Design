package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory.CloudServiceFactory;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudDatabase;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;

class CloudApplication {
    private CloudStorage storage;
    private CloudCompute compute;
    private CloudDatabase database;
    
    public CloudApplication(CloudServiceFactory factory) {
        // Create entire family of cloud services
        this.storage = factory.createStorage();
        this.compute = factory.createCompute();
        this.database = factory.createDatabase();
    }
    
    public void deployApplication() {
        System.out.println("Deploying application...");
        
        // Start compute instance
        compute.startInstance();
        
        // Upload application files
        storage.uploadFile("app.jar");
        storage.uploadFile("config.properties");
        
        // Setup database
        database.query("CREATE TABLE users");
        database.backup();
        
        System.out.println("Application deployed successfully!\n");
    }
    
    public void migrate() {
        System.out.println("Migrating data...");
        storage.downloadFile("data.zip");
        database.backup();
        System.out.println("Migration complete!\n");
    }
}