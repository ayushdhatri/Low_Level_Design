package Low_Level_Design.DesignPatterns.StructuralPattern.ProxyDesign;



public class Demo{
    public static void main(String[] args){
        ProxyInternet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("facebook.com");
        internet.connectTo("stackoverflow.com");
    }


}