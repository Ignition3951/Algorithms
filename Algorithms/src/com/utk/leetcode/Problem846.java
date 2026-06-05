package com.utk.leetcode;

import java.util.TreeMap;

public class Problem846 {

    static void main() {
        int[] hand = {1, 2, 3, 4, 5};
        int groupSize = 4;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int value : hand) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        while (!map.isEmpty()) {
            int key = map.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int count = i + key;

                if (!map.containsKey(count)) return false;

                int value = map.get(count);
                if (value == 1) {
                    map.remove(count);
                } else {
                    map.put(count, value - 1);
                }
            }
        }

        return true;
    }
}
