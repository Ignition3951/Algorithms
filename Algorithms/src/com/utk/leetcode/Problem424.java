package com.utk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem424 {

    static void main() {
        String str = "ABBB";
        int k = 2;
        System.out.println(characterReplacement(str, k));
    }

    public static int characterReplacement(String s, int k) {
        int maxlen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            } else {
                map.put(s.charAt(right), 1);
            }
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));
            if ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            if ((right - left + 1) - maxFreq <= k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            right++;
        }
        return maxlen;

    }
}
