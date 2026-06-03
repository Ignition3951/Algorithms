package com.utk.recursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Palindrome {

    private static final Logger LOGGER = Logger.getLogger(Palindrome.class.getName());

    public static void main(String[] args) {
        String str = "aabbaaa";
        LOGGER.log(Level.INFO, "Is the string \"{0}\" a palindrome? : {1}", new Object[]{str, isPalindrome(str, 0, str.length() - 1)});
        String leetcodestr = "A man, a plan, a canal: Panama";
        LOGGER.log(Level.INFO,"Is Palindrome {0}",isPalindromeLeetcode(leetcodestr));
    }

    public static boolean isPalindrome(String str, int startIndex, int endIndex) {
        if (startIndex == endIndex)
            return true;
        if (startIndex < endIndex) {
            if (str.charAt(startIndex) == str.charAt(endIndex))
                return isPalindrome(str, startIndex + 1, endIndex - 1);
            else
                return false;
        }
        return true;
    }

    public static boolean isPalindromeLeetcode(String str) {
        String modifiedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        modifiedStr = modifiedStr.replaceAll("\\s+", "");
        LOGGER.log(Level.INFO, "Modified String is : {0}", modifiedStr);
        return true;
    }
}
