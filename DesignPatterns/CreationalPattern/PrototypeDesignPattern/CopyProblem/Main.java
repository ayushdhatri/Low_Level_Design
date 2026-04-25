package Low_Level_Design.DesignPatterns.CreationalPattern.PrototypeDesignPattern.CopyProblem;

public class Main {
    public static void main(String[] args) {
        Email e1 = new Email("hello@world.com", "", "Test Email", "This is test email");
        Email e2 = e1.copy();

        e1.display();;
        e2.display();;

    }
    
}
