package Low_Level_Design.practice.CacheSystem.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LFUEvicitionPolicy<K> implements EvictionPolicies<K> {

    private class Node<K>{
        K key;
        Node<K> prev;
        Node<K> next;
        Node(K key){
            this.key = key;
        }
    }
    private class DoubleLinkedList<K>{
        private Node<K> head, tail;
        private int size ;

        public DoubleLinkedList(){
            head = new Node<>(null);
            tail = new Node<>(null);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addToHead(Node<K> node){
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        void removeNode(Node<K> node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node<K> removeTail(){
            if(size == 0)return null;
            Node<K> tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
    }

    private final Map<K, Integer> keyFrequencies;
    private final Map<K, Node<K>> keyNodes;
    private final Map<Integer, DoubleLinkedList> frequencyLists;
    private int minFrequency;

    LFUEvicitionPolicy(){
        this.keyFrequencies = new HashMap<>();
        this.keyNodes = new HashMap<>();
        this.frequencyLists = new HashMap<>();
        this.minFrequency = 0;
    }

    @Override
    public void keyAccessed(K key) {
        if(keyFrequencies.containsKey(key)){
            // we have to increase its frequency,
            // after increasing the frequency , lets say other nodes with same frequency exist,then in that case it should be pushed in front
            int currentFreq = keyFrequencies.get(key);
            Node<K> node = keyNodes.get(key);
            // remove node from its current frequency list
            DoubleLinkedList<K> currentList = frequencyLists.get(currentFreq);
            currentList.removeNode(node);

            // If we just emptied the minimum frequency list, increment minFrequency
            if(currentFreq == minFrequency && currentList.size == 0){
                minFrequency++;
            }

            // add it to the new list and in the front
            int newFreq = currentFreq + 1;
            keyFrequencies.put(key, newFreq);

            frequencyLists.computeIfAbsent(newFreq, k -> new DoubleLinkedList<>()).addToHead(node);
        }
        else{
            Node<K> newNode = new Node<>(key);
            keyNodes.put(key, newNode);
            keyFrequencies.put(key, 1);
            minFrequency = 1;
            frequencyLists.computeIfAbsent(minFrequency, k -> new DoubleLinkedList<>()).addToHead(newNode);
        }
        
    }

    @Override
    public K evict() {
        if(keyNodes.isEmpty()){
            return null;
        }
        // get the list of key that shares the absolute minimum frequency
        DoubleLinkedList<K> minFreqList = frequencyLists.get(minFrequency);
        Node<K> nodeToEvict = minFreqList.removeTail();

        K evictedKey = nodeToEvict.key;
        keyNodes.remove(evictedKey);
        keyFrequencies.remove(evictedKey);
        return evictedKey;
    }

    @Override
    public void hydrate(Set<K> keys) {
        keyFrequencies.clear();
        keyNodes.clear();
        frequencyLists.clear();
        minFrequency = 0;
        for(K key : keys){
            keyAccessed(key);
        }

        
    }
    
    
}
