package com.utk.leetcode.problem460;

import java.util.Arrays;
import java.util.List;

public class LRUCacheImpl {

    static void main() {
        LRUCache lruCache = null;
        int capacity = 1;
        List<String> operations = Arrays.asList("LRUCache", "put", "put", "get", "put", "get", "put", "get");//, "get", "get");
        List<List<Integer>> values = Arrays.asList
                (
                        List.of(capacity),
                        List.of(1, 1),
                        List.of(2, 2),
                        List.of(1),
                        List.of(3, 3),
                        List.of(2),
                        List.of(4, 4),
//                        List.of(1),
                        List.of(3)
//                        List.of(4)
                );

        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "LRUCache":
                    lruCache = new LRUCache(values.get(i).getFirst());
                    break;
                case "put":
                    assert lruCache != null;
                    lruCache.put(values.get(i).getFirst(), values.get(i).getLast());
                    break;
                case "get":
                    assert lruCache != null;
                    System.out.println(lruCache.get(values.get(i).getFirst()));
                    break;
            }
        }
    }
}
