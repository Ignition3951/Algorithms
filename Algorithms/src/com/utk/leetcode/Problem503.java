package com.utk.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem503 {

    static void main() {
        int[] nums1 = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums1)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int[] modifiedNums = new int[nums.length * 2];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < modifiedNums.length; i++) {
            index = i % nums.length;
            modifiedNums[i] = nums[index];
        }

        for (int i = modifiedNums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(modifiedNums[i]);
            } else {
                if (stack.peek() > modifiedNums[i]) {
                    if (i < nums.length) {
                        result[i] = stack.peek();
                    }

                    stack.push(modifiedNums[i]);
                } else {
                    while (!stack.isEmpty() && stack.peek() <= modifiedNums[i]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        if (i < nums.length) {
                            result[i] = stack.peek();
                        }
                    }
                    stack.push(modifiedNums[i]);
                }
            }
        }
        return result;
    }
}
