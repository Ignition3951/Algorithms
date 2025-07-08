package com.algo.abdulbari.search;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RecursiveBinarySearch {

    private static final Logger LOGGER = Logger.getLogger(RecursiveBinarySearch.class.getName());

    public static void main(String[] args) {
        int[] targetArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchElement = 20;
        int low = 0;
        int high = targetArray.length - 1;
        int result = recursiveBinarySearch(targetArray,searchElement,low,high);
        if(result != -1) {
            LOGGER.log(Level.INFO, "Key Element has been found on index: {}",result);
        } else {
            LOGGER.log(Level.INFO, "Key Element not found in the array.");
        }
    }

    public static int recursiveBinarySearch(int[] target,int key,int low,int high){
        int mid=(low+high)/2;
         if(low<=high){
             if(target[mid]==key)
                 return mid;
             if(target[mid]>key)
                 recursiveBinarySearch(target,key,low,mid-1);
             else
                 recursiveBinarySearch(target,key,mid+1,high);
         }
         return -1; // Element not found
    }
}
