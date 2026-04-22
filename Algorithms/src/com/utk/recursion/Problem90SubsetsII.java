package com.utk.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90SubsetsII {

    static void main() {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        subsetsWithDupHelper(0, arr, result, new ArrayList<>());
        return result;
    }

    public static void subsetsWithDupHelper(int index, int[] arr, List<List<Integer>> result, List<Integer> subsets) {
        if (index == arr.length) {
            if (!result.contains(subsets)) {
                result.add(new ArrayList<>(subsets));
            }
            return;
        }

        subsets.add(arr[index]);
        subsetsWithDupHelper(index + 1, arr, result, subsets);
        subsets.removeLast();
        subsetsWithDupHelper(index + 1, arr, result, subsets);
    }

}
