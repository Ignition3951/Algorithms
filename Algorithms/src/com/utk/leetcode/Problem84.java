package com.utk.leetcode;

import java.util.Stack;

// Largest rectangle in histogram
public class Problem84 {

    static void main() {
        System.out.println(largestRectangleArea(new int[]{1,1}));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] pse = preSmallerElement(heights);
        int[] nse = nextSmallerElement(heights);
        for (int i = 0; i < heights.length; i++) {
            int rectangleArea = heights[i] * (nse[i] - (pse[i] + 1));
            maxArea = Math.max(maxArea, rectangleArea);
        }
        return maxArea;
    }

    public static int[] preSmallerElement(int[] heights) {
        int[] pse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public static int[] nextSmallerElement(int[] heights) {
        int[] nse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i =heights.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }
}
