package Low_Level_Design.practice.MovieBooking.models.Theater;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.practice.MovieBooking.models.Users.Location;

public class Theatre {
    private final String theaterId;
    private final String theaterName;
    private final Location location;
    private final List<Movie> movies = new ArrayList<>();
    private final List<Auditorium> auditoriums = new ArrayList<>();

    public Theatre(String theaterId, String theaterName,Location location){
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.location = location;
    }

    public String getTheaterId(){
        return this.theaterId;
    }

    public String getTheaterName(){
        return this.theaterName;
    }

    public Location getLocation(){
        return this.location;
    }

    public List<Movie> getMovies(){
        return this.movies;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
        System.out.println("New Movie added successfully");
    }

    public List<Auditorium> getAuditoriums(){
        return this.auditoriums;
    }

    public void addAuditorium(Auditorium auditorium){
        this.auditoriums.add(auditorium);
        System.out.println("New Auditorium added successfully");
    }








    
}
