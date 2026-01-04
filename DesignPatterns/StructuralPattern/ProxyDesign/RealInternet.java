package Low_Level_Design.DesignPatterns.StructuralPattern.ProxyDesign;


class RealInternet implements Internet{
    @Override
    public void connectTo(String serverHost){
        System.out.println("Connecting to " + serverHost);
    }
}