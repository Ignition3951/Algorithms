package com.utk.linkedlist;

import com.utk.linkedlist.model.Node;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedListImpl {

    private static final Logger LOGGER = Logger.getLogger(LinkedListImpl.class.getName());

    public static void main(String[] args) {
        int[] target = {23, 89, 45, 90};
        Node head = new Node();
        head = head.convertArrayToLL(target);
        head = head.insertAtHead(head, 7);
        int searchItem = 8;
        LOGGER.log(Level.INFO, "Is the element present in the linked list : {0}", head.searchAnElement(head, searchItem));
        LOGGER.log(Level.INFO, "The length of the linked list is : {0}", head.lengthOfLinkedList(head));
        Node deleteNode = new Node(45);
        head.deleteNode(deleteNode);
        LOGGER.log(Level.INFO, "HEAD is : {0}", head.toString());

        int[] middleTarget = {1, 2, 3, 4, 5, 6};
        Node middleNode = new Node();
        middleNode = middleNode.convertArrayToLL(middleTarget);
        middleNode = middleNode.middleNode(middleNode);
        middleNode = middleNode.reverseList(middleNode);
        LOGGER.log(Level.INFO, "Middle of the Node is : {0}", middleNode.toString());

        int[] isPalidrome = {1, 2, 3, 2, 1,7};
        Node isPalidromeNode = new Node();
        isPalidromeNode = isPalidromeNode.convertArrayToLL(isPalidrome);
        LOGGER.log(Level.INFO, "Is the given LinkedList palindrome: {0}", isPalidromeNode.isPalindrome(isPalidromeNode));

    }
}
