package com.utk.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem2104 {

    static void main() {
        int[] arr = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(arr));
    }

    public static long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-Problem907.sumSubarrayMins(nums);
    }

    public static long sumSubarrayMaxs(int[] arr) {
        long total = 0;
        int[] nge = nextGreaterElement(arr);
        int[] pge = prevGreaterElement(arr);
        for (int i = 0; i < arr.length; i++) {
            // Count of elements to the left including current
            int left = i - pge[i];

            // Count of elements to the right including current
            int right = nge[i] - i;

            // Total subarrays where arr[i] is the minimum
            long freq = left * right * 1L;

            // Contribution = frequency * value
            long val = freq * arr[i];
            total = (total + val);
        }
        return total;
    }

    public static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length-1; i >=0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            res[i] = !stack.isEmpty() ? stack.peek() : arr.length;
            stack.push(i);
        }
        return res;
    }

    public static int[] prevGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            res[i] = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(i);
        }
        return res;
    }
}
