package com.algo.abdulbari.heap.main;

import java.util.Arrays;

public class MaxHeapify {

    static void main() {
        int[] minHeap = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int n = minHeap.length;
        for(int i=(n-2)/2;i>=0;--i){
            maxHeapify(minHeap,i);
        }
        System.out.println("Max Heap :" + Arrays.toString(minHeap));
    }

    static void maxHeapify(int[] arr,int node) {
        int left = 2*node+1;
        int right = 2*node+2;
        int largest = node;

        if(right<arr.length && arr[right]>arr[node]) {
            largest = right;
        }

        if(left<arr.length && arr[left]>arr[largest]) {
            largest = left;
        }

        if(largest != node){
            int temp = arr[node];
            arr[node] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr,largest);
        }
    }


}
