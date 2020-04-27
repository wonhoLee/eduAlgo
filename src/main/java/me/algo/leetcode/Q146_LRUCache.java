package me.algo.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
//https://www.youtube.com/watch?v=WOaQfWqlV7A
public class Q146_LRUCache {
//    public static void main(String[] args) {
//
//    }
//
//    public class CacheItem {
//        int key;
//        int value;
//        CacheItem prev;
//        CacheItem next;
//
//        public CacheItem(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    CacheItem head;
//    CacheItem tail;
//    int capacity;
//    Map<Integer, CacheItem> map;
//
//    public Q146_LRUCache(int capacity) {
//        head = null;
//        tail = null;
//        this.capacity = capacity;
//        map = new HashMap<>();
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key)) {
//            return -1;
//        } else {
//            CacheItem cur = map.get(key);
//
//            if (cur != head) {
//                // move cur to head;
//                if (cur == tail) {
//                    // move tail to one in front
//                    tail = tail.prev;
//                }
//
//                //move cur to head
//                if (cur.prev != null) cur.prev.next = cur.next;
//                if (cur.next != null) cur.next.prev = cur.prev;
//                cur.next = head;
//                head.prev = cur;
//                cur.prev = null;
//                head = cur;
//            }
//            return cur.value;
//        }
//    }
//
//    public void put(int key, int value) {
//        if (get(key) == -1) {
//            //insert
//            CacheItem cur = new CacheItem(key, value);
//            if(head == null){
//                head = cur;
//                tail = cur;
//            }else{
//                cur.next = head;
//                head.prev = cur;
//                head = cur;
//            }
//            map.put(key, cur);
//
//            if(map.size() > capacity){
//                //evict tail
//                map.remove(tail.key);
//                tail.prev.next = null;
//                tail = tail.prev;
//            }
//        } else {
//            //update
//            map.get(key).value = value;
//        }
//    }

    private LinkedHashMap<Integer,Integer> lru;
    private final int CAPACITY;
    public Q146_LRUCache(int capacity) {
        CAPACITY = capacity;
        lru = new LinkedHashMap<>(capacity,0.75f,true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > CAPACITY;
            }
        };


    }

    public int get(int key) {
        return lru.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        lru.put(key, value);
    }
}
