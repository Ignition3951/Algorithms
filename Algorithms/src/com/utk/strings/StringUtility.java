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
        int left = 0;
        int right = s.length() - 1;
        char ch;
        StringBuilder output = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (left <= right) {
            ch = s.charAt(left);
            if (ch != ' ') {
                temp.append(ch);
            } else {
                if (!output.isEmpty() && !temp.isEmpty()) {
                    temp.append(" ");
                    output.insert(0, temp);
                } else {
                    output.append(temp);
                }
                temp.setLength(0);
            }
            left++;
        }

        if (!temp.isEmpty()) {
            if (!output.isEmpty()) {
                temp.append(" ");
                output.insert(0, temp);
            } else {
                output.append(temp);
            }
        }

        return output.toString();
    }
}
