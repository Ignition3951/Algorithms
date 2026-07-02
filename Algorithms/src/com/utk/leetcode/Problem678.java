package com.utk.leetcode;

public class Problem678 {

    static void main() {

        String str = "(*))";
//        String str = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        //(((((*(*********((*(((((****          (*))
        System.out.println(checkValidString(str));
    }

    public static boolean checkValidString(String s) {
        return helperCheckValidString(s, 0, 0);
    }

    public static boolean helperCheckValidString(String s, int index, int counter) {

        if (counter < 0) {
            return false;
        }
        if (index == s.length()) return counter == 0;

        if (s.charAt(index) == '(') {
            counter++;
            return helperCheckValidString(s, index + 1, counter);
        } else if (s.charAt(index) == ')') {
            counter--;
            return helperCheckValidString(s, index + 1, counter);
        } else {
            return helperCheckValidString(s, index + 1, counter)
                    || helperCheckValidString(s, index + 1, counter + 1)
                    || helperCheckValidString(s, index + 1, counter - 1);
        }

    }
}
