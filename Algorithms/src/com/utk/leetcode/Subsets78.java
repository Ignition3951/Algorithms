package com.utk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    static void main() {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int subsets = 1<<nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < subsets; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if((i&(1<<j))!=0){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
