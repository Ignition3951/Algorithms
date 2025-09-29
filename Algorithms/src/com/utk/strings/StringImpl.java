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

        String[] longestPrefix = {"ab","a"};
        LOGGER.log(Level.INFO, "The longest string prefix is : {0}", StringUtility.longestCommonPrefix(longestPrefix));
    }
}
