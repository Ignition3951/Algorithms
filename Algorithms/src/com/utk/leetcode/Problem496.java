package com.utk.leetcode;

import java.util.Arrays;

public class Problem496 {

    static void main() {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            int j=0;
            while(nums2[j]!=nums1[i]){
                j++;
            }
            for(int k=j;k<nums2.length;k++){
                if(nums2[k]>nums1[i]){
                    result[i]=nums2[k];
                    break;
                }
            }
        }
        return result;
    }
}
