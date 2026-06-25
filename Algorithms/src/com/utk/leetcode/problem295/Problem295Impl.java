package com.utk.leetcode.problem295;

import java.util.Arrays;
import java.util.List;

public class Problem295Impl {

    static void main() {
        Problem295 p = null;
        List<String> operations = Arrays.asList("MedianFinder", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian");
        List<List<Integer>> values = Arrays.asList(
                List.of(),
                List.of(-1),
                List.of(),
                List.of(-2),
                List.of(),
                List.of(-3),
                List.of(),
                List.of(-4),
                List.of(),
                List.of(-5),
                List.of()
        );
        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "MedianFinder":
                    p = new Problem295();
                    break;
                case "addNum":
                    assert p != null;
                    p.addNum(values.get(i).getFirst());
                    break;
                case "findMedian":
                    assert p != null;
                    System.out.println(p.findMedian());
                    break;
            }
        }
    }
}
