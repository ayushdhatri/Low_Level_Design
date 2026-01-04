package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AzureCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;

public class AzureStorage implements CloudStorage {
    public void uploadFile(String fileName) {
        System.out.println("  Uploading " + fileName + " to Azure Blob Storage");
    }
    public void downloadFile(String fileName) {
        System.out.println("  Downloading " + fileName + " from Azure Blob");
    }
}