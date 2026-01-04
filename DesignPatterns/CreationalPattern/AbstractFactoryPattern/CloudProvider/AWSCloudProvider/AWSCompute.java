package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudProvider.AWSCloudProvider;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface.CloudCompute;

public class AWSCompute implements CloudCompute {
    public void startInstance() {
        System.out.println("  Starting AWS EC2 instance");
    }
    public void stopInstance() {
        System.out.println("  Stopping AWS EC2 instance");
    }
}