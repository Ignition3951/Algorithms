package com.utk.leetcode.problem460;

public class DoublyLinkedList {

    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    public void addNodeHead(Node node) {
        Node nextNode = head.getNext();
        head.setNext(node);
        nextNode.setPrev(node);
        node.setNext(nextNode);
        node.setPrev(head);
        size++;
    }

    public void removeNode(Node node) {
        Node prevNode = node.getPrev();
        Node nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
