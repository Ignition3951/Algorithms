package com.utk.leetcode;

public class Problem678 {

    static void main() {

        String str = "(*)";
        System.out.println(checkValidString(str));
    }

    public static boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }

            if (minOpen < 0) minOpen = 0;
            if (maxOpen < 0) return false;
        }
        return true;
    }

}
