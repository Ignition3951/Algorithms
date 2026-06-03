package com.utk.leetcode.problem225;

import java.util.Arrays;
import java.util.List;

public class Problem225Impl {

    static void main() {
        Problem225 p = null;//["MyStack", "push", "push", "top", "pop", "empty"]
        //[[], [1], [2], [], [], []]
        List<String> operations = Arrays.asList("MyStack", "push", "push", "top", "pop", "empty","pop","empty");
        List<List<Integer>> values = Arrays.asList(
                List.of(),
                List.of(1),
                List.of(2),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of());

        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "MyStack":
                    p = new Problem225();
                    break;
                case "push":
                    p.push(values.get(i).getFirst());
                    break;
                case "top":
                    assert p != null;
                    System.out.println(p.top());
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
