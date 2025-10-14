package com.utk.linkedlist;

import com.utk.linkedlist.model.DoubleNode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DoublyLinkedList {

    private static final Logger LOGGER = Logger.getLogger(DoublyLinkedList.class.getName());

    public static void main(String[] args) {
        int[] target = {89, 23, 67, 34, 90, 65, 32};
        DoubleNode head = new DoubleNode().convertToDoublyLinkedList(target);
        head = head.deleteKthElement(head, 2);
        head = head.deleteHead(head);
        head = head.deleteTail(head);
        head.deleteNode(head.getNext().getNext());
        head = head.insertBeforeHead(head, 45);
        head = head.reverseDLL(head);
        LOGGER.log(Level.INFO, "{0}", head.toString());

        int[] deleteAllOccurrence = {7,7,7,7};
        int deleteElement = 7;
        DoubleNode deleteAllOccNode = new DoubleNode().convertToDoublyLinkedList(deleteAllOccurrence);
        deleteAllOccNode = deleteAllOccNode.deleteAllOccurrence(deleteAllOccNode, deleteElement);
        LOGGER.log(Level.INFO, "Doubly linked list after deleting all the elements is :{0}", deleteAllOccNode.toString());

    }
}
