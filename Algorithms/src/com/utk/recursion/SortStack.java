package com.utk.recursion;

import java.util.Stack;

public class SortStack {

    static void main() {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(55);
        stack.push(2);
        stack.push(47);
        stack.push(28);
        sortStack(stack);//55 47 28 4 2
        reverseStack(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    static void sortStack(Stack<Integer> stack) {
        if(stack.size()<=1){
            return;
        }
        int current = stack.pop();
        sortStack(stack);
        pushStack(stack,current);
    }

    static void pushStack(Stack<Integer> stack,int element) {
        if(stack.isEmpty() || stack.peek()<=element){
            stack.push(element);
            return;
        }
        int current  =  stack.pop();
        pushStack(stack,element);
        stack.push(current);
    }

    static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int current = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack,current);
    }

    static void insertAtBottom(Stack<Integer> stack,int element){
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack,element);
        stack.push(top);
    }
}
