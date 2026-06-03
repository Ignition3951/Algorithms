package com.utk.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem907 {

    static void main() {
        int[] arr = new int[]{1,2,3};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int total = 0;
        int[] nse = nextSmallerElement(arr);
        int[] pse = prevSmallerElement(arr);
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            // Count of elements to the left including current
            int left = i - pse[i];

            // Count of elements to the right including current
            int right = nse[i] - i;

            // Total subarrays where arr[i] is the minimum
            long freq = left * right * 1L;

            // Contribution = frequency * value
            int val = (int) ((freq * arr[i]) % mod);
            total = (total + val) % mod;
        }
        return total;
    }

    public static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            res[i] = !stack.isEmpty() ? stack.peek() : arr.length;

            stack.push(i);
        }
        return res;
    }

    public static int[] prevSmallerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }

            res[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }
        return res;
    }
}
