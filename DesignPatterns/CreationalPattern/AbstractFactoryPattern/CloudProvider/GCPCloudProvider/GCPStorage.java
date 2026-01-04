package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.GCPCloudProvider;


import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;

public class GCPStorage implements CloudStorage {
    public void uploadFile(String fileName) {
        System.out.println("  Uploading " + fileName + " to Google Cloud Storage");
    }
    public void downloadFile(String fileName) {
        System.out.println("  Downloading " + fileName + " from GCS");
    }
}