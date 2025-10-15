package com.utk.linkedlist.model;

import java.util.ArrayList;
import java.util.List;

public class DoubleNode {

    int data;
    DoubleNode next;
    DoubleNode back;

    public DoubleNode() {
        this.data = 0;
        this.next = null;
        this.back = null;
    }

    public DoubleNode(int data, DoubleNode next, DoubleNode back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    public DoubleNode(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode convertToDoublyLinkedList(int[] target) {
        DoubleNode head = new DoubleNode(target[0]);
        DoubleNode temp = head;
        for (int i = 1; i < target.length; i++) {
            DoubleNode current = new DoubleNode(target[i], null, temp);
            temp.next = current;
            temp = current;
        }
        return head;
    }

    public DoubleNode deleteHead(DoubleNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DoubleNode prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    public DoubleNode deleteTail(DoubleNode head) {
        if (head == null || head.next == null) return null;
        DoubleNode temp = head;
        while (head.next != null) {
            head = head.next;
        }
        DoubleNode prev = head.back;
        prev.next = null;
        head.back = null;
        return temp;
    }

    public DoubleNode deleteKthElement(DoubleNode head, int position) {
        if (head == null) {
            return null;
        }
        int counter = 0;
        DoubleNode kthDoubleNode = head;
        while (kthDoubleNode != null) {
            ++counter;
            if (counter == position) break;
            kthDoubleNode = kthDoubleNode.next;
        }

        DoubleNode front = kthDoubleNode.next;
        DoubleNode prev = kthDoubleNode.back;

        if (front == null && prev == null) {
            return null;
        } else if (prev == null) {
            return deleteHead(head);
        } else if (front == null) {
            return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;

        return head;
    }

    public void deleteNode(DoubleNode node) {
        DoubleNode prev = node.back;
        DoubleNode front = node.next;

        if (front == null) {
            prev.next = null;
            node.back = null;
            return;
        }

        prev.next = front;
        front.back = prev;
        node.next = null;
        node.back = null;
    }

    public DoubleNode insertBeforeHead(DoubleNode head, int target) {
        DoubleNode newHead = new DoubleNode(target, head, null);
        head.back = newHead;
        return newHead;
    }

    public DoubleNode reverseDLL(DoubleNode head) {
        if (head.next == null) {
            return head;
        }
        int counter = 0;
        while (head.next != null) {
            ++counter;
            head = head.next;
        }
        DoubleNode newHead = head;
        while (counter >= 0) {
            --counter;
            swapPositions(head, head.next, head.back);
            head = head.next;
        }
        return newHead;
    }

    public void swapPositions(DoubleNode head, DoubleNode front, DoubleNode back) {
        head.next = back;
        head.back = front;
    }

    public DoubleNode deleteAllOccurrence(DoubleNode head, int target) {
        DoubleNode temp = head;
        while (head != null) {
            if (head.data == target) {
                DoubleNode prevNode = head.back;
                DoubleNode nextNode = head.next;
                if (prevNode == null && nextNode == null) {
                    return null;
                }
                if (prevNode == null) {
                    temp = temp.next;
                    temp.back = null;
                } else if (nextNode == null) {
                    prevNode.next = null;
                } else {
                    prevNode.next = nextNode;
                    nextNode.back = prevNode;
                }
            }
            head = head.next;
        }
        return temp;
    }

    public List<List<Integer>> findPairsWithGivenSum(DoubleNode head, int target) {
        DoubleNode low = head;
        DoubleNode high = head.next;
        int value = 0;
        List<List<Integer>> results = new ArrayList<>();
        while (high.next != null) {
            high = high.next;
        }
        while (low.data <= high.data) {
            List<Integer> result = new ArrayList<>();
            value = low.data + high.data;
            if (value == target) {
                result.add(low.data);
                result.add(high.data);
                results.add(result);
                low = low.next;
            } else if (value < target) {
                low = low.next;
            } else {
                high = high.back;
            }
        }

        return results;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
