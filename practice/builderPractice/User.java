package Low_Level_Design.practice.builderPractice;


public class User{
    private String username;
    private String password;
    private int age;
    private String address;

    private User(Builder builder){
        // this initilize the values of user 
        this.username = builder.username;
        this.password = builder.password;
        this.age = builder.age;
        this.address = builder.address;
    }
    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public int getAge(){
        return this.age;
    }

    public String getAddress(){
        return this.address;
    }

    public static class Builder{
        private String username;
        private String password;
        private int age;
        private String address;

        // lets set the value which is mandatory 
        public Builder(String username, String password){
            this.username = username;
            this.password = password;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public User build(){
            // do some validation 

            return new User(this);
        }
    }

    @Override
    public String toString(){
        System.out.println("Username of the person is : " + this.username);
        System.out.println("Password of the person is : " + this.password);
        System.out.println("Age of the person is : " + this.age);
        System.out.println("Address of the person is : " + this.address);
        return "";
    }


}