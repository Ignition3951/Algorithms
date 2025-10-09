package com.utk.linkedlist.model;

public class Node {

    private int data;
    private Node next;

    public Node() {
        this.data = 0;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node convertArrayToLL(int[] target) {
        Node head = new Node(target[0], null);
        Node temp = head;
        for (int i = 1; i < target.length; i++) {
            temp.next = new Node(target[i], null);
            temp = temp.next;
        }
        return head;
    }

    public Node insertAtHead(Node head, int x) {
        return new Node(x, head);
    }

    public int searchAnElement(Node head, int target) {
        while (head.next != null) {
            if (head.data == target) return 1;
            head = head.next;
        }
        return 0;
    }

    public int lengthOfLinkedList(Node head) {
        int counter = 1;
        while (head.next != null) {
            head = head.next;
            ++counter;
        }
        return counter;
    }

    public void deleteNode(Node node) {
        while (node.next != null) {
            if (node.next.data == node.data) {
                node.next = node.next.next;
                node.next.next = null;
                return;
            }
            node = node.next;
        }
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
