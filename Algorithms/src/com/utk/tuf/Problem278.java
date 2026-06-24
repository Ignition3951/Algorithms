package com.utk.tuf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem278 {

    void main() {
        int[] arr1 = {3, 4, 5};
        int[] arr2 = {2, 6, 3};
        int k = 2;
        System.out.println(Arrays.toString(maxSumCombinations(arr1, arr2, k)));
    }

    public int[] maxSumCombinations(int[] arr1, int[] arr2, int k) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] result = new int[k];
        int length1 = arr1.length - 1;
        int length2 = arr2.length - 1;
        int counter = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        maxHeap.offer(new int[]{arr1[length1] + arr2[length2], length1, length2});
        Set<String> visited = new HashSet<>();
        visited.add(length1 + "," + length2);

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0];
            int i = current[1];
            int j = current[2];
            result[counter++] = sum;

            if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
                maxHeap.offer(new int[]{arr1[i - 1] + arr2[j], i - 1, j});
                visited.add(i - 1 + "," + j);
            }

            if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
                maxHeap.offer(new int[]{arr1[i] + arr2[j - 1], i, j - 1});
                visited.add(i + "," + (j - 1));
            }
        }
        return result;
    }
}
