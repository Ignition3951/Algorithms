package com.utk.leetcode;

import java.util.Arrays;

public class Problem455 {

    static void main() {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPointer = 0;
        int sPointer = 0;
        while (gPointer < g.length && sPointer < s.length) {
            if (g[gPointer] <= s[sPointer]) {
                gPointer++;
            }
            sPointer++;
        }
        return gPointer;
    }
}
