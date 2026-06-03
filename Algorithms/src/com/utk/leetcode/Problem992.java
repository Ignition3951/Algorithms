package com.utk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem992 {

    static void main() {
        int[] nums = {2, 1, 1, 1, 2};
        int k = 1;
        System.out.println(subarraysWithKDistinct(nums, k) - subarraysWithKDistinct(nums, k - 1));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            if (map.containsKey(nums[right])) {
                map.put(nums[right], map.get(nums[right]) + 1);
            } else {
                map.put(nums[right], 1);
            }
            if (map.size() > k) {
                while (map.size() > k) {
                    int value = map.get(nums[left]);
                    if (value == 1) {
                        map.remove(nums[left]);
                    } else {
                        map.put(nums[left], value - 1);
                    }
                    left++;
                }
            }
            result += (right - left + 1);
            right++;

        }
        return result;
    }
}
