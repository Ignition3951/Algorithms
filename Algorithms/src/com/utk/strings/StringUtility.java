package com.utk.strings;

import java.util.*;

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
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        // Get length of the strings
        int n = s.length();
        // Loop through all characters in the strings
        for (int i = 0; i < n; ++i) {
            // Return false if mapping is inconsistent
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;

            // Update last seen index for both characters
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        // Return true if all character mappings are consistent
        return true;
    }

    public static boolean rotateString(String s, String goal) {
        String compare = s + s;
        int counter = 0;
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < compare.length(); i++) {
            while (counter < s.length() && (i + counter) < compare.length() && compare.charAt(i + counter) == goal.charAt(counter)) {
                counter++;
            }
            if (counter >= s.length()) {
                return true;
            } else {
                counter = 0;
            }
        }
        return false;
    }

    public static boolean isAnagram(String s, String t) {
        String sortedStrings1 = sortString(s);
        String sortedStrings2 = sortString(t);

        return sortedStrings1.equals(sortedStrings2);
    }

    public static String sortString(String s) {
        char[] sortedArray = s.toCharArray();
        Arrays.sort(sortedArray);
        return new String(sortedArray);
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        //Create a frequency map of string
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());

        sortedList.sort((entry1, entry2) -> {
            // Sort by frequency in descending order
            int frequencyComparison = entry2.getValue().compareTo(entry1.getValue());
            if (frequencyComparison != 0) {
                return frequencyComparison;
            }
            // If frequencies are equal, sort by character in ascending order
            return entry2.getKey().compareTo(entry1.getKey());
        });

        StringBuilder resultBuilder = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : sortedList) {
            resultBuilder.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }

        return resultBuilder.toString();
    }

    public static int maxDepthOfParenthesis(String s) {
        int counter = 0;
        int result = Integer.MIN_VALUE;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                counter++;
                result = Math.max(result, counter);
            } else if (ch == ')') {
                counter--;
            }
        }
        return result;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        int result = 0;
        int pointer1;
        int pointer2;
        int i = 0;
        while (i < s.length()) {
            pointer1 = values.get(s.charAt(i));

            if (i + 1 < s.length() && pointer1 < values.get(s.charAt(i + 1))) {
                pointer2 = values.get(s.charAt(++i));
                result += (pointer2 - pointer1);
            } else {
                result += pointer1;
            }
            i++;
        }
        return result;
    }

    public static int myAtoi(String s) {

        // Initialize index, sign, and result
        int i = 0;
        int sign = 1;
        // Use long to prevent overflow
        long res = 0;

        // Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') i++;

        // Return 0 if only spaces are found
        if (i == s.length()) return 0;

        // Check for optional '+' or '-' sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Convert characters to integer while valid digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i) - '0');

            // Clamp to Integer.MAX_VALUE if overflow
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;

            // Clamp to Integer.MIN_VALUE if underflow
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        // Return final result after applying sign
        return (int) (sign * res);

    }

    public static int countSubstrings(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    public static int atMostKDistinct(String s, int k) {
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }

            res += (right - left + 1);
        }
        return res;
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxLength;

        //Start from the center and expand till characters are same
        for (int center = 0; center < s.length(); center++) {
            int lengthOdd = expandFromCentre(s, center, center);
            int lengthEven = expandFromCentre(s, center, center + 1);

            maxLength = Math.max(lengthEven, lengthOdd);

            //Calculate the starting and ending point of the sub string
            if (maxLength > (end - start)) {
                start = center - (maxLength - 1) / 2;
                end = center + maxLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandFromCentre(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
