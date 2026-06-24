package com.utk.leetcode.problem703;

import java.util.PriorityQueue;

public class KthLargest {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final int kthLargest;

    public KthLargest(int k, int[] nums) {
        kthLargest = k;
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }
    }

    public int add(int val) {
        if (minHeap.isEmpty()) {
            minHeap.add(val);
            return minHeap.peek();
        }

        minHeap.add(val);
        if (minHeap.size() > kthLargest) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
