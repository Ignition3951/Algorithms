package com.utk.leetcode;

public class Problem930 {

    //[1,0,1,0,1], goal = 2
    static void main() {
        int[] arr = {0, 0, 0, 0, 0};
        int goal = 0;
        int result = numSubarraysWithSum(arr, goal)-numSubarraysWithSum(arr, goal-1);
        System.out.println(result);
    }

    public static int numSubarraysWithSum(int[] arr, int goal) {
        if(goal<0) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int count=0;
        while(right < arr.length) {
            sum += arr[right];
            while(sum>goal){
                sum -= arr[left++];
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}
