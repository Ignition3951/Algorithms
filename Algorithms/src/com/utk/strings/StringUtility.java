package com.utk.strings;

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
        String result="";
        int value;
        for (int j=num.length()-1;j>=0;j--) {
            value=num.charAt(j)-'0';
            if (value % 2 != 0) {
                result = num.substring(0,j+1);
                break;
            }
        }
        return result;
    }
}
