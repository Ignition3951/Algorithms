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
}
