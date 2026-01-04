package Low_Level_Design.DesignPatterns.StructuralPattern.ProxyDesign;

import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
    private RealInternet internet = new RealInternet();
    private static List<String> bannedSites = Arrays.asList(
        "facebook.com",
        "twitter.com",
        "instagram.com"
    );

    @Override
    public void connectTo(String serverHost){
        if(bannedSites.contains(serverHost.toLowerCase())){
            System.out.println("Access Denied : " + serverHost + " is blocked!");
            return;
        }
        internet.connectTo(serverHost);


    }
}