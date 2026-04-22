package com.utk.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeRecursion {

    static void main() {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public static void combinationSum2Helper(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> innerList) {
        if (target == 0) {
            result.add(new ArrayList<>(innerList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (target < candidates[i]) break;
            innerList.add(candidates[i]);
            target -= candidates[i];
            combinationSum2Helper(candidates, target, i + 1, result, innerList);
            innerList.removeLast();
            target += candidates[i];
        }
    }

}
