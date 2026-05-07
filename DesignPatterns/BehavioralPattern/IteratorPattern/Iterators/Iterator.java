package Low_Level_Design.DesignPatterns.BehavioralPattern.IteratorPattern.Iterators;

import java.util.List;
public interface Iterator<T> {
    boolean hasNext();
    T next();
} 