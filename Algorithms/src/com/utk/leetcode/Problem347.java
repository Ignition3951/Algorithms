package com.utk.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem347 {

    static void main() {
        int[] num = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(num, k)));
    }

    public static int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        int counter = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }
        while (!pq.isEmpty() && k-- > 0) {
            res[counter++] = pq.poll()[0];
        }
        return res;
    }
}
