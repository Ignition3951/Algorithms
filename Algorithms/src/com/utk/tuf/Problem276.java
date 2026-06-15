package com.utk.tuf;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem276 {

    static void main() {
        List<Integer> list = Arrays.asList(1, 8, 3, 5);
        System.out.println(connectSticks(list));
    }

    public static int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.offer(stick);
        }
        int minCost = 0;
        while (pq.size() > 1) {
            int firstSmallest = pq.poll();
            int secondSmallest = pq.poll();

            int count = firstSmallest + secondSmallest;

            minCost += count;
            pq.offer(count);

        }
        return minCost;
    }

}
