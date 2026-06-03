package com.utk.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem239 {

    static void main() {
        int[] arr = new int[] {1};//{1,3,-1,-3,5,3,6,7};
        int k=1;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int counter=0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekFirst()] < nums[i]) {
                queue.pollFirst();
            }
            queue.offerFirst(i);
            if(!queue.isEmpty() && queue.peekLast() < i-k+1){
                queue.pollLast();
            }
            if(i>=k-1){
               res[counter++]=nums[queue.peekLast()];
            }

        }
        return res;
    }


}

