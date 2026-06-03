package com.utk.leetcode;

import java.util.*;

public class Problem3 {

    static void main() {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left=0;
        int right=0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left){
                left = map.get(s.charAt(right))+1;
            }
            max = Math.max(max, right-left+1);
            map.put(s.charAt(right), right++);
        }
        return max;
    }
}
