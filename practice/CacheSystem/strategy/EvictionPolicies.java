package Low_Level_Design.practice.CacheSystem.strategy;

import java.util.Set;

import Low_Level_Design.practice.CacheSystem.Cache;

public interface EvictionPolicies<K> {
    // called every time a key is access or added so that we can insert the data into our eviction policy ds
    void keyAccessed(K key);

    K evict();// this returns the key to be evicted

    void hydrate(Set<K> keys);// when we change the policy this is used to transfer to new policy

}
