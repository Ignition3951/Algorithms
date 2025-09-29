package com.utk.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtility {

    private StringUtility() {

    }

    public static String removeOuterParenthesis(String s) {
        StringBuilder result = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (opened > 0) {
                    result.append(c);
                }
                opened++;
            } else {
                opened--;
                if (opened > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static String reverseWords(String s) {
        String[] arrayOfWords = s.split("\\s+");
        StringBuilder reverseString = new StringBuilder();
        for (int i = arrayOfWords.length - 1; i >= 0; i--) {
            reverseString.append(arrayOfWords[i]);
            reverseString.append(" ");
        }
        return reverseString.toString().trim();
    }

    public static String largestOddNumber(String num) {
        String result = "";
        int value;
        for (int j = num.length() - 1; j >= 0; j--) {
            value = num.charAt(j) - '0';
            if (value % 2 != 0) {
                result = num.substring(0, j + 1);
                break;
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strings) {
        Arrays.sort(strings);
        String first = strings[0];
        String last = strings[strings.length - 1];
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> values = new HashMap<>();
        char a;
        char b;
        boolean result = true;
        for (int k = 0; k < s.length(); k++) {
            a = s.charAt(k);
            b = t.charAt(k);
            if ((values.containsKey(a) && b != values.get(a)) || (!values.containsKey(a) && values.containsValue(b))) {
                result = false;
            }

            values.put(a, b);
        }
        return result;
    }
}
