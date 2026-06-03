package com.utk.tuf;

import java.util.ArrayList;
import java.util.List;

// Palindrome partitioning
public class Problem174 {

    static void main() {
        System.out.println(partition("aabaa"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(result, s, 0, new ArrayList<>());
        return result;
    }

    public static void partitionHelper(List<List<String>> result, String s, int startingIndex, List<String> partition) {
        if (startingIndex == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        StringBuilder temp = new StringBuilder();

        for (int i = startingIndex; i < s.length(); i++) {
            temp.append(s.charAt(i));
            String sub = temp.toString();
            if (checkPalindrome(sub)) {
                partition.add(sub);
                partitionHelper(result, s, i + 1, partition);
                partition.removeLast();
            }

        }
    }

    public static boolean checkPalindrome(String str) {
        int startPointer = 0;
        int endPointer = str.length() - 1;
        while (startPointer < endPointer) {
            if (str.charAt(startPointer) != str.charAt(endPointer)) {
                return false;
            } else {
                startPointer++;
                endPointer--;
            }
        }
        return true;
    }
}
