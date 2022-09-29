package HashMaps;

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 5;
        for(int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hCode = key.hashCode();
        //compressing the hashcode
        int index = hCode%numBuckets;
        return index;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);

        //to check, if the key is already there and update the value if present
        while(head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        //when the key is not present
        head = buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        double loadFactor = (1.0*count)/numBuckets;
        if(loadFactor > 0.7) {
            reHash();
        }
    }

    private void reHash() {
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();
        for(int i = 0; i < 2*numBuckets; i++) {
            buckets.add(null);
        }

        numBuckets = 2*numBuckets;
        //count is set to zero because the insert() function will increse
        //the size of count
        count = 0;

        for(int i = 0; i < temp.size(); i++) {
            MapNode<K,V> head = temp.get(i);
            while(head != null) {
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }

    public int size() {
        return count;
    }

    public double loadFactor() {
        return (1.0*count)/numBuckets;
    }

    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;
        while(head != null) {
            if(head.key.equals(key)) {
                if(prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }

        return null;
    }
}