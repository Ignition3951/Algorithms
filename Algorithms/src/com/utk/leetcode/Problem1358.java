package com.utk.leetcode;

public class Problem1358 {

    static void main() {
        String str = "abcabc";
        System.out.println(numberOfSubstrings(str));
    }

    public static int numberOfSubstrings(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        int[] charCounter = new int[3];
        while (right < s.length()) {
            int value = convertCharToInt(s.charAt(right));
            charCounter[value]++;
            while (checkValidity(charCounter)) {
                result += (s.length() - right);
                int leftValue = convertCharToInt(s.charAt(left));
                charCounter[leftValue]--;
                left++;
            }
            right++;
        }
        return result;
    }

    public static int convertCharToInt(char ch) {
        if (ch == 'a') return 0;
        if (ch == 'b') return 1;
        return 2;
    }

    public static boolean checkValidity(int[] charCounter) {
        return charCounter[0] > 0 && charCounter[1] > 0 && charCounter[2] > 0;
    }
}
