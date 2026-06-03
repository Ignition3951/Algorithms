package com.utk.leetcode.problem460;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> map;
    Deque<Integer> keys;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        keys = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            if (!keys.isEmpty() && keys.peekFirst() != key) {
                keys.remove(key);
                keys.addFirst(key);
            }
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() >= capacity) {
            int removed = keys.removeLast();
            map.remove(removed);
        }
        map.put(key, value);
        keys.addFirst(key);
    }
}
