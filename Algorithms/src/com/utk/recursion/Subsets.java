package com.utk.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static void main() {
        System.out.println(subsetSums(new int[]{1}));

    }

    public static List<Integer> subsetSums(int[] arr) {
        List<Integer> result = new ArrayList<>();
        subSetsSumsHelper(arr, result, new ArrayList<>(), 0);
        return result;
    }

    public static void subSetsSumsHelper(int[] arr, List<Integer> result, List<Integer> innerList, int index) {
        if (index >= arr.length) {
            result.add(sumOfList(new ArrayList<>(innerList)));
            return;
        }

        innerList.add(arr[index]);
        subSetsSumsHelper(arr, result, innerList, index + 1);
        innerList.removeLast();
        subSetsSumsHelper(arr, result, innerList, index+1);
    }

    public static int sumOfList(List<Integer> list){
        int sum = 0;
        for(int value: list){
            sum+=value;
        }
        return sum;
    }
}
