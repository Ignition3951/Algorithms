package com.utk.leetcode.problem155;

import com.utk.leetcode.problem232.Problem232;

import java.util.Arrays;
import java.util.List;

public class MinStackImpl {

    static void main() {
        MinStack minStack=null;
        List<String> operations = Arrays.asList("MinStack","push","push","push","getMin","pop","top","getMin");
        List<List<Integer>> values = Arrays.asList(List.of(),
                List.of(-2),
                List.of(0),
                List.of(-3),
                List.of(),
                List.of(),
                List.of(),
                List.of());
        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "MinStack":
                    minStack = new MinStack();
                    break;
                case "push":
                    minStack.push(values.get(i).getFirst());
                    break;
                case "top":
                    assert minStack != null;
                    System.out.println(minStack.top());
                    break;
                case "pop":
                    minStack.pop();
                    break;
                case "getMin":
                    System.out.println(minStack.getMin());
                    break;
            }
        }
    }
}
