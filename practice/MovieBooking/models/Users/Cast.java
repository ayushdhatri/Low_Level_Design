package Low_Level_Design.practice.MovieBooking.models.Users;

public class Cast extends Person {
    private final String rolePlayed;
    public Cast(String name, String rolePlayed){
        super(name);
        this.rolePlayed = rolePlayed;
    }

    public String getRolePlayed(){
        return this.rolePlayed;
    }
}
