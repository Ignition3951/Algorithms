package com.utk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem76 {

    static void main() {
        String s="a";
        String t="aa";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startingIndex = 0;
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()) {
            if (targetMap.containsKey(s.charAt(right))) {
                int value = targetMap.get(s.charAt(right));
                if (value > 0) {
                    count++;
                }
                targetMap.put(s.charAt(right), value - 1);
            } else {
                targetMap.put(s.charAt(right), -1);
            }
            if (count == t.length()) {
                while (count == t.length()) {
                    if (targetMap.containsKey(s.charAt(left))) {
                        int value = targetMap.get(s.charAt(left));
                        if (value == 0) {
                            if(minLen > (right - left +1)){
                                minLen = right - left +1;
                                startingIndex = left;
                            }
                            count--;
                        }
                            targetMap.put(s.charAt(left), value + 1);
                    }
                    left++;
                }
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startingIndex, startingIndex+minLen);
    }
}
