package com.algo.abdulbari.heap.service;

public interface HeapService {

    void buildHeap(int[] arr, int size);

    void heapify(int[] arr, int size, int index);

    void swap(int[] arr, int i, int j);

    int[] addElement(int[] arr,int size,int element);

    int[] deleteRootElement(int[] arr);

    int findKthLargestElement(int[] arr, int k);
}
