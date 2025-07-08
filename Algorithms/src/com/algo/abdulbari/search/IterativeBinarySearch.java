package com.algo.abdulbari.search;

public class IterativeBinarySearch {

    public static void main(String[] args) {
        //Array should be sorted for binary search to work
        int[] targetArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int searchElement = 1;
        binarySearch(targetArray,searchElement);

    }

    public static void binarySearch(int[] target,int key){
        int targetArraySize = target.length;
        int low=0;
        int high=targetArraySize-1;
        int mid=(low+high)/2;

        while(low<=high){
            mid=(low+high)/2;
            if(target[mid]==key){
                System.out.println("Key Element has been found on index :"+mid);
            }
            if(target[mid]>key) {
                high = mid - 1;
            }else{
                low=mid+1;
            }
        }
    }
}
