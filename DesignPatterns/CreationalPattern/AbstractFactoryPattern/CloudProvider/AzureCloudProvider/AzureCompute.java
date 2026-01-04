package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AzureCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;

public class AzureCompute implements CloudCompute {
    public void startInstance() {
        System.out.println("  Starting Azure Virtual Machine");
    }
    public void stopInstance() {
        System.out.println("  Stopping Azure Virtual Machine");
    }
}