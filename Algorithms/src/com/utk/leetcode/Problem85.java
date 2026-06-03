package com.utk.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem85 {

    static void main() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(maximalRectangle(matrix));

    }

    public static int maximalRectangle(char[][] matrix) {
        int col = matrix[0].length;
        int[] heights = new int[col];
        int maxRectangleArea = 0;
        Arrays.fill(heights, 0);
        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++) {
                if (chars[j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += chars[j] - '0';
                }
            }
            maxRectangleArea = Math.max(maxRectangleArea, largestRectangleArea(heights));
        }
        return maxRectangleArea;
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
