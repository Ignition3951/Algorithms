package com.utk.leetcode;

public class MinBitFlips2220 {

    static void main() {
        System.out.println(minBitFlips(3, 4));
    }

    public static int minBitFlips(int start, int goal) {
        int res = (start ^ goal);
        int flips = 0;
        while (res > 0) {
            if ((res & 1) == 1) {
                ++flips;
            }
            res >>= 1;
        }
        return flips;
    }
}
