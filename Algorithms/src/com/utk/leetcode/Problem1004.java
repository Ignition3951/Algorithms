package com.utk.leetcode;

public class Problem1004 {

    static void main() {
        int[] arr = {0,0,1,1,1,0,0};
        int k=0;
        System.out.println(longestOnes(arr, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int counter=0;
        int  left=0;
        int right=0;
        int result = 0;
        while(left<=right && right<nums.length){
            if(nums[right]==1){
                right++;
            }else if(nums[right]==0 && counter<k){
                right++;
                counter++;
            }else if(left!=right){
                if(nums[left]==1){
                    left++;
                }else{
                    left++;
                    counter--;
                }
            }else{
                left++;
                right++;
            }
            result = Math.max(result, right-left);
        }
        return result;
    }
}
