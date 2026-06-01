package Low_Level_Design.practice.CopyProblem;

public class Main {
    public static void main(String[] args){
        Email e1 = new Email("hello@world.com", "null", "testEmail", "This is a teset email");
        // this is calling the copy constructor
        Email e2 = new Email(e1);
        if(e1 instanceof Email){
            e2 = new Email(e1);
        }
        else if(e1 instanceof PreimiumEmail){
            e2 = new PreimiumEmail();
        }

        // This violates ocp princple, 

        // so what better we can do is simply creates an interface and force class to implement them
        Email e3 = e2.copy();
     
    }
}
