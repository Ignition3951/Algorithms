package com.utk.leetcode;

import java.util.*;

public class Problem3 {

    static void main() {
        String str = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int counter = 0;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.contains(s.charAt(i))) {
                counter = Math.max(counter, stack.size());
                while (!stack.isEmpty() && stack.peekLast() != s.charAt(i)) {
                    stack.pollLast();
                }
                stack.pollLast();
            }
            stack.push(s.charAt(i));
        }
        counter = Math.max(counter, stack.size());
        return counter;
    }
}
