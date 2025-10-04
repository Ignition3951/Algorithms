package com.utk.strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringImpl {

    private static final Logger LOGGER = Logger.getLogger(StringImpl.class.getName());

    public static void main(String[] args) {
        String s = "()()";
        LOGGER.log(Level.INFO, "The char array is : {0}", StringUtility.removeOuterParenthesis(s));

        String reverseString = "  hello world  ";
        LOGGER.log(Level.INFO, "The reverse of the string is : {0}", StringUtility.reverseWords(reverseString));

        String largestOddNumber = "7542351161";
        LOGGER.log(Level.INFO, "The largest odd number in the string is : {0}", StringUtility.largestOddNumber(largestOddNumber));

        String[] longestPrefix = {"ab", "a"};
        LOGGER.log(Level.INFO, "The longest string prefix is : {0}", StringUtility.longestCommonPrefix(longestPrefix));

        String s1 = "egg";
        String s2 = "add";
        LOGGER.log(Level.INFO, "Are the strings isoMorphic : {0}", StringUtility.isIsomorphic(s1, s2));

        String source = "abcde";
        String goal = "debac";
        LOGGER.log(Level.INFO, "Are the strings just rotated versions of each other : {0}", StringUtility.rotateString(source, goal));

        String s3 = "anagram";
        String s4 = "nagaram";
        LOGGER.log(Level.INFO, "Are the strings anagram : {0}", StringUtility.isAnagram(s3, s4));

        String s5 = "Aabb";
        LOGGER.log(Level.INFO, "The sorted string according to frequency of characters is :{0}", StringUtility.frequencySort(s5));

        String s6 = "()(())((()()))";
        LOGGER.log(Level.INFO, "The maximum depth of the parenthesis is : {0}", StringUtility.maxDepthOfParenthesis(s6));

        String s7 = "III";
        LOGGER.log(Level.INFO, "The conversion of roman numeral {0} to int is : {1}", new Object[]{s7, StringUtility.romanToInt(s7)});

        String s8 = "+-12";
        LOGGER.log(Level.INFO, "The string to integer conversion is : {0}", StringUtility.myAtoi(s8));

        String s9 = "abcbaa";
        int distinctCharacters = 3;
        LOGGER.log(Level.INFO, "The number of distinct character substrings are : {0}", StringUtility.countSubstrings(s9, distinctCharacters));

        String s10 = "babad";
        LOGGER.log(Level.INFO, "The longest palindromic sub string is : {0}", StringUtility.longestPalindrome(s10));
    }
}
