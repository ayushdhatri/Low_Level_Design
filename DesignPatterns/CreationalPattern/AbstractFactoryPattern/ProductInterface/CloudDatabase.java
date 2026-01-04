package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface;
import java.util.*;
public interface CloudDatabase {
    void query(String sql);
    void backup();
}