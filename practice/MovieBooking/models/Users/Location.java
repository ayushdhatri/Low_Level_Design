package Low_Level_Design.practice.MovieBooking.models.Users;

public class Location {
    private String state;
    private String city;
    public Location(String state, String city){
        this.state = state;
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public void changeState(String newState){
        this.state = newState;
    }

    public void changeCity(String newCity){
        this.city = newCity;
    }
}
