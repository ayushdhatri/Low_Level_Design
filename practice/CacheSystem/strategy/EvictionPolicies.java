package Low_Level_Design.practice.CacheSystem.strategy;

import Low_Level_Design.practice.CacheSystem.Cache;

public interface EvictionPolicies {
    void removeItem(Cache cache);// its task is to remove the item from cache according to different polices
}
