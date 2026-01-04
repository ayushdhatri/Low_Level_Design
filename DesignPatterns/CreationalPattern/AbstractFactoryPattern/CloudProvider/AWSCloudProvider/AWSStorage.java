package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AWSCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudStorage;
public class AWSStorage implements CloudStorage {
    public void uploadFile(String fileName) {
        System.out.println("  Uploading " + fileName + " to AWS S3 bucket");
    }
    public void downloadFile(String fileName) {
        System.out.println("  Downloading " + fileName + " from AWS S3");
    }
}