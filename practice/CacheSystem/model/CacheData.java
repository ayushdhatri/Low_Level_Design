package Low_Level_Design.practice.CacheSystem.model;

public class CacheData{
    private final int key;
    private final String value;
    public CacheData(int key, String value){
        this.key = key;
        this.value = value;
    }
    public int getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }
}