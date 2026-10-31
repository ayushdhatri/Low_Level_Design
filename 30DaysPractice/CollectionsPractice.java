import java.util.HashMap;
import java.util.Map;

public class CollectionsPractice{
    public static void main(String[] args){
        // HashMap
        // TreeMap
        // LinkedHashMap
        // concurrent HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("John", 250);
        hashMap.put("Jane", 30);
        hashMap.put("Jim", 35);

        System.out.println(hashMap.get("John"));
        

    }
}