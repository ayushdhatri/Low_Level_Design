package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern;

import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory.AWSFactory;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory.CloudServiceFactory;
import Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.CloudServiceFactory.GCPFactory;

class CloudConfig {
    public static CloudServiceFactory getFactory(String provider) {
        switch (provider.toLowerCase()) {
            case "aws":
                return new AWSFactory();
            case "azure":
                return new AWSFactory();
            case "gcp":
                return new GCPFactory();
            default:
                throw new IllegalArgumentException("Unknown provider: " + provider);
        }
    }
}
