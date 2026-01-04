


package Low_Level_Design.DesignPatterns.CreationalPattern.FactoryPattern.Example2;

public class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Notify user via Email");
    }
}