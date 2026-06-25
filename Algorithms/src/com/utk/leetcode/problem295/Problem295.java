package com.utk.leetcode.problem295;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem295 {

    private static PriorityQueue<Integer> minHeap;
    private static PriorityQueue<Integer> maxHeap;
    private static int size;

    public Problem295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        size = 0;
    }

    public void addNum(int num) {
        size++;
        maxHeap.add(num);

        minHeap.add(maxHeap.poll());

        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());

    }

    public double findMedian() {
       if(size%2 == 0) {
           return (maxHeap.peek()+minHeap.peek())/2.0;
       }else{
           return maxHeap.peek();
       }
    }
}
