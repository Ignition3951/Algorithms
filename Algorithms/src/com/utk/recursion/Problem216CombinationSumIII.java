package com.utk.recursion;

import java.util.ArrayList;
import java.util.List;

public class Problem216CombinationSumIII {

    static void main() {
        System.out.println(combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3Helper(res, k, n, new ArrayList<>(), 1, n);
        return res;
    }

    public static void combinationSum3Helper(List<List<Integer>> result, int k, int n, List<Integer> temp, int index, int target) {
        if (target == 0 && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0 || temp.size() > k) return;

        for (int i = index; i <= 9; i++) {
            if (i <= target) {
                temp.add(i);
                combinationSum3Helper(result, k, n, temp, i + 1, target - i);
                temp.removeLast();
            } else {
                break;
            }
        }
    }
}
