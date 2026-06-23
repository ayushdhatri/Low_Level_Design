package Low_Level_Design.practice.CacheSystem;

import java.util.HashMap;
import java.util.Map;

import Low_Level_Design.practice.CacheSystem.strategy.EvictionPolicies;

public class Cache<K, V> {
    private EvictionPolicies<K> evictionPolicies;
    private final Map<K, V> storage;
    private final int capacity;

    public Cache(int capacity, EvictionPolicies<K> initialPolicy){
        this.capacity = capacity+1;
        this.evictionPolicies = initialPolicy;
        this.storage = new HashMap<>();
    }

    public void put(K key, V value){
        // eviction policy is used when storage reaches its capacity
        if(capacity == 0) return ;
        if(!storage.containsKey(key)){
            if(storage.size() == capacity){
                K keyToEvict = evictionPolicies.evict();
                if(keyToEvict != null){
                    storage.remove(keyToEvict);
                    System.out.println("hje");
                }
            }
        }
        storage.put(key, value);
        evictionPolicies.keyAccessed(key);
    }

    public V get(K key){
        // if you get the keys, respective evictino policy keyset should be updated regarding its access
        if(!storage.containsKey(key)){
            return null;
        }
        this.evictionPolicies.keyAccessed(key);
        return storage.get(key);
    }

    public void setEvicitionPolicy(EvictionPolicies<K> newPolicy){
        this.evictionPolicies = newPolicy;
        // we need to hydrate the data as well
        this.evictionPolicies.hydrate(storage.keySet());
    }

    public int size(){
        return storage.size();
    }

    
}
