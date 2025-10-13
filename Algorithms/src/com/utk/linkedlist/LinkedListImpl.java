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

        int[] isPalidrome = {1, 2};
        Node isPalidromeNode = new Node();
        isPalidromeNode = isPalidromeNode.convertArrayToLL(isPalidrome);
        LOGGER.log(Level.INFO, "Is the given LinkedList palindrome: {0}", isPalidromeNode.isPalindrome(isPalidromeNode));
        isPalidromeNode = isPalidromeNode.oddEvenLinkedList(isPalidromeNode);
        LOGGER.log(Level.INFO, "Odd even linked list is  : {0}", isPalidromeNode.toString());
        isPalidromeNode = isPalidromeNode.removeNthFromEnd(isPalidromeNode, 1);
        LOGGER.log(Level.INFO, "The modified node after removal is : {0}", isPalidromeNode.toString());

        int[] deleteMiddle = {2, 1};
        Node deleteMiddleNode = new Node();
        deleteMiddleNode = deleteMiddleNode.convertArrayToLL(deleteMiddle);
        deleteMiddleNode = deleteNode.deleteMiddleNode(deleteMiddleNode);
        LOGGER.log(Level.INFO, "The Linked List after deleting the middle node is : {0}", deleteMiddleNode.toString());

        int[] sortLinkedList = {4, 2, 1, 3};
        Node sortLinkedListNode = new Node();
        sortLinkedListNode = sortLinkedListNode.convertArrayToLL(sortLinkedList);
        sortLinkedListNode = sortLinkedListNode.sortLinkedList(sortLinkedListNode);
        LOGGER.log(Level.INFO, "The Sorted Linked List is : {0}", sortLinkedListNode.toString());

        int[] sortLinkedList0And1 = {2, 2, 1, 2};
        Node sortLinkedList0And1Node = new Node();
        sortLinkedList0And1Node = sortLinkedList0And1Node.convertArrayToLL(sortLinkedList0And1);
        sortLinkedList0And1Node = sortLinkedList0And1Node.sortListOf0And1(sortLinkedList0And1Node);
        LOGGER.log(Level.INFO, "The Sorted Linked List of 0,1 and 2 is : {0}", sortLinkedList0And1Node.toString());

    }
}
