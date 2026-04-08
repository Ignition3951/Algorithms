package com.utk.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Valid Parenthesis
public class Problem20 {

    static void main() {
        String str = "]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> values = new HashMap<>();
        values.put('(', ')');
        values.put('{', '}');
        values.put('[', ']');
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (values.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && c == values.get(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
