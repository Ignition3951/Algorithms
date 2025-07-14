package com.algo.abdulbari.heap.main;

import com.algo.abdulbari.heap.serviceimpl.HeapServiceImpl;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KthLargestElementMain {

    private static final Logger LOGGER = Logger.getLogger(KthLargestElementMain.class.getName());

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        HeapServiceImpl heapServiceImpl = new HeapServiceImpl();
        int size = arr.length;
        heapServiceImpl.buildHeap(arr, size);
        LOGGER.log(Level.INFO,"Heapified Array: {0}",Arrays.toString(arr));
        int k = 11; // Find the 3rd largest element
        int kthLargest = heapServiceImpl.findKthLargestElement(arr, k);
        LOGGER.log(Level.INFO, "{0} largest element is: {1}", new Object[]{k, kthLargest});
        int[] modifiedHeap = heapServiceImpl.addElement(arr, size, 20);
        LOGGER.log(Level.INFO,"Heap after adding the element:  {0}",Arrays.toString(modifiedHeap));
    }
}
