package com.utk.leetcode;

import java.util.Stack;

// Largest rectangle in histogram
public class Problem84 {

    static void main() {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int nse;
        int element;
        int pse;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            nse = i;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                element = stack.pop();
                pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - (pse + 1)));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nse = heights.length;
            element = stack.pop();
            pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - (pse + 1)));
        }
        return maxArea;
    }
}
