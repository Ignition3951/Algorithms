package com.utk.leetcode;

import java.util.*;

public class Problem17 {

    static void main() {
        System.out.println(letterCombinations("345"));

    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        letterCombinationHelper(map,digits,result,0,new StringBuilder() );

        return result;
    }

    public static void letterCombinationHelper(Map<Integer,List<Character>> map, String digits, List<String> result, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for(Character c : map.get(digits.charAt(index)-'0')) {
            sb.append(c);
            letterCombinationHelper(map, digits, result, index + 1, sb);
            sb.deleteCharAt(index);
        }

    }
}
