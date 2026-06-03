package com.utk.leetcode.problem460;

public class Node {

    private int key;
    private int value;
    private int count;
    private Node prev;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getCount() {
        return count;
    }
}
