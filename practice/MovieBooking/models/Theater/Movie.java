package Low_Level_Design.practice.MovieBooking.models.Theater;

import java.util.List;

import Low_Level_Design.practice.MovieBooking.models.Users.Cast;

public class Movie {
    private final String movieId;
    private final String movieName;
    private final String description;
    private final List<Cast> castList;
    private final int rating;

    public Movie(String movieId, String movieName, String description, List<Cast> castList, int rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.description = description;
        this.castList = castList;
        this.rating = rating;
    }

    public String getMovieId() { return movieId; }
    public String getMovieName() { return movieName; }
    public String getDescription() { return description; }
    public List<Cast> getCastList() { return castList; }
    public int getRating() { return rating; } 
}
