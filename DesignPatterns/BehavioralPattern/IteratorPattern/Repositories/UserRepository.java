package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Repositories;

import java.util.List;

public interface UserRepository {
    List<String> findUsers(int limit, int offset);

}