package com.utk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddOperators282 {

    static void main() {
        System.out.println(addOperators("123", 6));
    }

    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        addOperatorsHelper(num, target, res, 0, "", 0, 0);
        return res;
    }

    public static void addOperatorsHelper(String num, int target, List<String> res, int currentValue, String expression, int index, int lastOperand) {
        if (index == num.length()) {
            if (currentValue == target) {
                res.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            String currentChar = num.substring(index, i + 1);
            int currentNumValue = Integer.parseInt(currentChar);
            if (index == 0) {
                addOperatorsHelper(num, target, res, currentNumValue, expression + currentChar, index + 1, currentNumValue);
            } else {
                addOperatorsHelper(num, target, res, currentValue + currentNumValue, expression + "+" + currentChar, index + 1, currentNumValue);
                addOperatorsHelper(num, target, res, currentValue - currentNumValue, expression + "-" + currentChar, index + 1, currentNumValue);
                addOperatorsHelper(num, target, res, currentValue - lastOperand + lastOperand * currentNumValue, expression + "*" + currentChar, index + 1, currentNumValue);
            }

        }

    }

}
