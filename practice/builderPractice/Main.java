package Low_Level_Design.practice.builderPractice;

public class Main {
    public static void main(String [] args){
        User newUser = new User.Builder("ayush", "password123")
                        .age(24)
                        .address("mugreshpallya")
                        .build();
        newUser.toString();


    }
}
