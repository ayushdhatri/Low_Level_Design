package Low_Level_Design.practice.CacheSystem.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUEvicitionPolicy<K> implements EvictionPolicies<K> {

    private static class Node<K>
    {
        K key;
        Node<K> prev;
        Node<K> next;
        Node(K key)
        {
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }
    private final Map<K, Node<K>> mapper;
    private final Node<K> head;
    private final Node<K> tail;

    public LRUEvicitionPolicy(){
        this.mapper = new HashMap<>();
        // Initilize dummy head and tail to eliminate null-pointer edge cases
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    private void addToHead(Node<K> node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node<K> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    @Override
    public void keyAccessed(K key) {
        if(mapper.containsKey(key)){
            Node<K> node = mapper.get(key);
            removeNode(node);
            // move it to front
            addToHead(node);
        }
        else{
            Node<K> newNode = new Node<>(key);
            mapper.put(key, newNode);
            addToHead(newNode);
        }
       
    }

    @Override
    public K evict() {
        // If map is empty, there is nothing to evict
        if(mapper.isEmpty()){
            return null;
        }

        Node<K> lruNode = tail.prev;
        removeNode(lruNode);
        mapper.remove(lruNode.key);
        return lruNode.key;
    }

    @Override
    public void hydrate(Set<K> keys) {
        mapper.clear();// this will clear all the elements from the map
        head.next = tail;
        tail.prev = head;

        for(K key : keys){
            this.keyAccessed(key);
        }

    }
    
}
