package com.utk.tuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem276 {

    static void main() {
        List<Integer> list = Arrays.asList(1, 8, 3, 5);
        Collections.sort(list);
        System.out.println(connectSticks(list));
    }

    public static int connectSticks(List<Integer> sticks) {
        int minCost = 0;
        int pointer = sticks.size() - 1;
        while (pointer > 0) {
            minCost += sum(sticks, pointer--);
        }
        return minCost;
    }

    public static int sum(List<Integer> sticks, int pointer) {
        int sum = 0;
        for (int i = pointer; i >= 0; i--) {
            sum += sticks.get(i);
        }
        return sum;
    }
}
