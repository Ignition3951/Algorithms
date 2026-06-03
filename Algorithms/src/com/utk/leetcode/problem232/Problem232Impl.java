package com.utk.leetcode.problem232;

import com.utk.leetcode.problem225.Problem225;

import java.util.Arrays;
import java.util.List;

public class Problem232Impl {

    static void main() {
        Problem232 p = null;
        List<String> operations = Arrays.asList("MyQueue", "push", "push", "peek", "pop", "empty");
        List<List<Integer>> values = Arrays.asList(List.of(), 
                List.of(1), 
                List.of(2),
                List.of(),
                List.of(),
                List.of());
        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "MyQueue":
                    p = new Problem232();
                    break;
                case "push":
                    p.push(values.get(i).getFirst());
                    break;
                case "peek":
                    assert p != null;
                    System.out.println(p.peek());
                    break;
                case "pop":
                    System.out.println(p.pop());
                    break;
                case "empty":
                    System.out.println(p.empty());
                    break;
            }
        }
    }
}
