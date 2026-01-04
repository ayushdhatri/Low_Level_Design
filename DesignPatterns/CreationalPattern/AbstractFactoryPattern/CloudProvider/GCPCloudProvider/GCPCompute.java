package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.GCPCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;

public class GCPCompute implements CloudCompute {
    public void startInstance() {
        System.out.println("  Starting Google Compute Engine instance");
    }
    public void stopInstance() {
        System.out.println("  Stopping GCE instance");
    }
}