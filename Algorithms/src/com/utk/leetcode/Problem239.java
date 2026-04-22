package com.utk.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem239 {

    static void main() {
        int[] arr = new int[] {1};//{1,3,-1,-3,5,3,6,7};
        int k=1;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int counter=0;
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while(i<k){
            max = Math.max(max,nums[i]);
            queue.offer(nums[i++]);
        }
        int size = nums.length-k+1;
        int[] res = new int[size];
        res[counter++] = max;
        while(i<nums.length){
            queue.remove();
            queue.offer(nums[i++]);
            max = maxElementInQueue(new LinkedList<>(queue));
            res[counter++] = max;
        }
        return res;
    }

    public static int maxElementInQueue(Queue<Integer> queue) {
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            max = Math.max(max,queue.poll());
        }
        return max;
    }
}

