package com.utk.leetcode.problem460;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer, Node> keyNode;
    Map<Integer, DoublyLinkedList> freqMap;
    int maxCapacity;
    int minFrequency;
    int currentCapacity;

    public LFUCache(int maxCapacity) {
        keyNode = new HashMap<>();
        freqMap = new HashMap<>();
        this.maxCapacity = maxCapacity;
        minFrequency = 0;
        currentCapacity = 0;
    }

    private void updateFreqMap(Node node) {
        keyNode.remove(node.getKey());

        freqMap.get(node.getCount()).removeNode(node);

        if (node.getCount() == minFrequency && freqMap.get(node.getCount()).getSize() == 0) {
            minFrequency++;
        }
        node.setCount(node.getCount() + 1);

        DoublyLinkedList list = new DoublyLinkedList();
        if (freqMap.containsKey(node.getCount())) {
            list = freqMap.get(node.getCount());
        }
        list.addNodeHead(node);
        freqMap.put(node.getCount(), list);
        keyNode.put(node.getKey(), node);

    }

    public int get(int key) {
        Node node = keyNode.get(key);
        if (node == null) {
            return -1;
        }
        updateFreqMap(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.setValue(value);
            updateFreqMap(node);
        } else {
            if (currentCapacity == maxCapacity) {
                Node delNode = freqMap.get(minFrequency).getTail().getPrev();
                keyNode.remove(delNode.getKey());
                freqMap.get(minFrequency).removeNode(delNode);
                currentCapacity--;
            }
            currentCapacity++;
            minFrequency = 1;
            Node newNode = new Node(key, value);
            keyNode.put(key, newNode);
            DoublyLinkedList list = new DoublyLinkedList();
            if (freqMap.containsKey(minFrequency)) {
                list = freqMap.get(minFrequency);
            }
            list.addNodeHead(newNode);
            freqMap.put(minFrequency, list);

        }
    }

}
