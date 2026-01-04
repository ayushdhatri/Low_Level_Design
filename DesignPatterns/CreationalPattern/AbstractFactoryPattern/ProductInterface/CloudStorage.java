
package Low_Level_Design.DesignPatterns.CreationalPattern.AbstractFactoryPattern.ProductInterface;
import java.util.*;

public interface CloudStorage {
    void uploadFile(String fileName);
    void downloadFile(String fileName);
}