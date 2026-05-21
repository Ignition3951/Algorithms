package com.utk.leetcode.problem460;

import java.util.Arrays;
import java.util.List;

public class LFUCacheImpl {

    static void main() {
        LFUCache lfucache = null;
        int capacity = 2;
        List<String> operations = Arrays.asList("LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get");
        List<List<Integer>> values = Arrays.asList
                (
                        List.of(capacity),
                        List.of(1, 1),
                        List.of(2, 2),
                        List.of(1),
                        List.of(3, 3),
                        List.of(2),
                        List.of(3),
                        List.of(4, 4),
                        List.of(1),
                        List.of(3),
                        List.of(4)
                );

        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "LFUCache":
                    lfucache = new LFUCache(values.get(i).getFirst());
                    break;
                case "put":
                    assert lfucache != null;
                    lfucache.put(values.get(i).getFirst(), values.get(i).getLast());
                    break;
                case "get":
                    assert lfucache != null;
                    System.out.println(lfucache.get(values.get(i).getFirst()));
                    break;
            }
        }
    }
}
