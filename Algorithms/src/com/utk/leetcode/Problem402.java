package com.utk.leetcode;


import java.util.Stack;

// Remove k digits to get smallest integer
public class Problem402 {

    static void main() {
        System.out.println(removeKdigits("112", 1));
    }

    public static String removeKdigits(String num, int k) {
        if (k>=num.length()){
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        int counter = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(num.charAt(i) - '0');
            } else {
                while (!stack.isEmpty() && stack.peek() > num.charAt(i) - '0' && counter < k) {
                    stack.pop();
                    counter++;
                }
                stack.push(num.charAt(i) - '0');

            }
        }
        while(counter<k){
            stack.pop();
            counter++;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        String removeZeroes = result.reverse().toString();
        StringBuilder modifiedResult = new StringBuilder();
        int i = 0;
        while (i<removeZeroes.length() && removeZeroes.charAt(i) == '0') {
            i++;
        }
        while (i < removeZeroes.length()) {
            modifiedResult.append(removeZeroes.charAt(i++));
        }

        return modifiedResult.toString().isEmpty() ?"0":modifiedResult.toString();
    }
}
