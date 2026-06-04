package com.utk.leetcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Problem621 {

    static void main() {
        char[] list = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        int n = 2;
        System.out.println(leastInterval(list, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new ConcurrentHashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;

            int i = 0;
            while (i < cycle && !maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;
                if (count > 0) {
                    temp.add(count);
                }
                i++;
                time++;
            }

            maxHeap.addAll(temp);

            if (!maxHeap.isEmpty()) {
                time += (cycle - i);
            }
        }
        return time;
    }
}
