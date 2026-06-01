package com.utk.leetcode;

public class Problem1248 {

    static void main() {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};//{1, 1, 2, 1, 1};//2,2,2,1,2,2,1,2,2,2
        int k = 2;
        System.out.println(numberOfSubarrays(arr, k)-numberOfSubarrays(arr, k-1));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int result = 0;
        while (right < nums.length) {
            if(isOdd(nums[right])){
                count++;
            }
            if(count>k){
                while(!isOdd(nums[left])){
                    left++;
                }
                left++;
                count--;
            }
            result+=(right - left+1);
            right++;
        }
        return result;
    }

    public static boolean isOdd(int num) {
        return !(num % 2 == 0);
    }
}
