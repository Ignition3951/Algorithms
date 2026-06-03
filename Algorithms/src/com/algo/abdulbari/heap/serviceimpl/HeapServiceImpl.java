package com.algo.abdulbari.heap.serviceimpl;

import com.algo.abdulbari.heap.service.HeapService;

import java.util.Arrays;

public class HeapServiceImpl implements HeapService {


    @Override
    public void buildHeap(int[] arr, int size) {
        int lastNonLeafIndex = (size / 2) - 1;
        for (int i = lastNonLeafIndex; i >= 0; i--) {
            heapify(arr, size, i);
        }
    }

    @Override
    public void heapify(int[] arr, int size, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < size && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, size, largest);
        }
    }

    @Override
    public void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    @Override
    public int[] addElement(int[] arr, int size, int element) {
        int[] maxHeap = Arrays.copyOf(arr, arr.length + 1);
        maxHeap[arr.length] = element;
        buildHeap(maxHeap, maxHeap.length);
        return maxHeap;
    }

    @Override
    public int[] deleteRootElement(int[] arr) {
        int[] maxHeap = Arrays.copyOfRange(arr, 0, arr.length - 1);
        maxHeap[0] = arr[arr.length - 1];
        buildHeap(maxHeap, maxHeap.length);
        return maxHeap;
    }

    @Override
    public int findKthLargestElement(int[] arr, int k) {
        int[] maxHeap = Arrays.copyOfRange(arr, 0, arr.length);
        for (int i = 1; i < k; i++) {
            maxHeap = deleteRootElement(maxHeap);
        }
        return maxHeap[0];
    }
}
