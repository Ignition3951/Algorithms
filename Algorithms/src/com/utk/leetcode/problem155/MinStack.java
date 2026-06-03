package com.utk.leetcode.problem155;

import java.util.Stack;

public class MinStack {

    Stack<Pair> stack = null;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair(val, val));
        } else {
            Pair pair = stack.peek();
            int min = Math.min(pair.getValue(), val);
            stack.push(new Pair(val, min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getKey();
    }

    public int getMin() {
        return stack.peek().getValue();
    }
}
