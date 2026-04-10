package com.utk.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem42 {

    static void main() {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int total = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                total += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                total += rightMax - height[right--];
            }
        }
        return total;
    }


}
