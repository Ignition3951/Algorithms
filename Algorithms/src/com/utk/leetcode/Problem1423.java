package com.utk.leetcode;

public class Problem1423 {

    static void main() {
        int[] nums = {9,7,7,9,7,7,9};//{1, 2, 3, 4, 5, 6, 1};
        int k = 7;
        System.out.println(maxScore(nums, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = cardPoints.length - 1;
        int maxSum = 0;
        int sum;
        if (k == cardPoints.length) {
            for (int point : cardPoints) {
                maxSum += point;
            }
            return maxSum;
        }
        while (left < k) {
            maxSum += cardPoints[left++];
        }
        --left;
        sum = maxSum;
        while (left >= 0) {
            sum = (sum - cardPoints[left]) + cardPoints[right];
            left--;
            right--;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
