package com.utk.leetcode;

// Largest rectangle in histogram
public class Problem84 {

    static void main() {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea =0;
        int minValue;
        for(int i = 0; i<heights.length; i++){
            minValue = Integer.MAX_VALUE;
            for(int j=i; j<heights.length; j++){
                minValue=Math.min(minValue,heights[j]);
                maxArea=Math.max(maxArea,(j-i+1)*minValue);
            }
        }
        return maxArea;
    }
}
