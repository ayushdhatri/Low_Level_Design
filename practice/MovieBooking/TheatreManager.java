package Low_Level_Design.practice.MovieBooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Low_Level_Design.practice.MovieBooking.models.Theater.Theatre;

public class TheatreManager {
    private final Map<String, List<Theatre>> cityTheaterMap = new ConcurrentHashMap<>();

    public void addTheater(Theatre theater) {
        cityTheaterMap.computeIfAbsent(theater.getLocation().getCity().toLowerCase(), k -> new ArrayList<>()).add(theater);
    }

    public List<Theatre> getTheatersByCity(String city) {
        return cityTheaterMap.getOrDefault(city.toLowerCase(), Collections.emptyList());
    }
}

