package com.utk.strings;

import java.util.Stack;

public class StringUtility {

    private StringUtility() {

    }

    public static String removeOuterParenthesis(String s) {
        Stack<Character> parenthesis = new Stack<>();
        StringBuilder output = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                if (!parenthesis.isEmpty()) {
                    output.append(ch);
                    parenthesis.push(ch);
                } else {
                    parenthesis.push(ch);
                }
            } else {
                parenthesis.pop();
                if (!parenthesis.isEmpty()) {
                    output.append(ch);
                }
            }
        }
        return new String(output);
    }
}
