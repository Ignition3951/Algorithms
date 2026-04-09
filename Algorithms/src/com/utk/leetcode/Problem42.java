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
        int[] leftMax = prefixMax(height);
        int[] rightMax = postfixMax(height);
        for(int i=0; i<height.length; i++){
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return total;
    }

    public static int[] prefixMax(int[] height) {
        int[] result = new int[height.length];
        result[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            int maxValue = Math.max(height[i], result[i - 1]);
            result[i] = maxValue;
        }
        return result;
    }

    public static int[] postfixMax(int[] height){
        int[] result = new int[height.length];
        result[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            int maxValue = Math.max(height[i], result[i + 1]);
            result[i] = maxValue;
        }
        return result;
    }
}
