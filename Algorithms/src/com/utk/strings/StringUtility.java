package com.utk.strings;

public class StringUtility {

    private StringUtility() {

    }

    public static String removeOuterParenthesis(String s) {
        char[] arr = s.toCharArray();
        arr[0] = ' ';
        int i = 0;
        int j = 1;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == '(') j++;
            if (arr[k] == ')') j--;
            if (j == 0) {
                arr[i] = ' ';
                arr[k] = ' ';
                i = k + 1;
            }
        }
        String str = new String(arr);
        return str.replaceAll("\\s+", "");
    }
}
