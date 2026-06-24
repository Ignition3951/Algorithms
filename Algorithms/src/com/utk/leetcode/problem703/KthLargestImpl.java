package com.utk.leetcode.problem703;

import java.util.Arrays;
import java.util.List;

public class KthLargestImpl {

    static void main() {
        KthLargest kthLargest=null;
        List<String> operations = Arrays.asList("KthLargest", "add", "add", "add", "add", "add");
        List<List<Integer>> values = Arrays.asList(
                List.of(3),
                List.of(4,5,8,2),
                List.of(3),
                List.of(5),
                List.of(10),
                List.of(9),
                List.of(4)
        );

        int[] array = values.get(1).stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int k=values.get(0).getFirst();

        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "KthLargest":
                    kthLargest = new KthLargest(k,array);
                    System.out.println("null ");
                    break;
                case "add":
                    System.out.println(kthLargest.add(values.get(i+1).getFirst()));
                    break;
            }
        }
    }
}
