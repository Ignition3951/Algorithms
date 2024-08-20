package com.algo.service;

public class QuickSortService implements SortingService {

	@Override
	public void sort(String[] a) {
		int N=a.length;
		quickSort(a, 0, N-1);
	}
	
	public void quickSort(String[] a,int low,int high) {
		//Condition to check whether the array is broken down to its smallest sub-array
		if(low<high) {
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot-1);
			quickSort(a, pivot+1, high);
		}
		
	}
	
	public int partition(String[] a,int low,int high) {
		//Selecting the right most element as the pivot
		int pivot=high;
		//Taking initial value as -1 so that once incremented will swap the correct value
		int i=low-1;
		for(int j=low;j<=high-1;j++) {
			if(SortingService.less(a[j], a[pivot])) {
				i++;
				//Exchanging the value if it is less 
				SortingService.exchange(a, i, j);
			}
		}
		//Putting the pivot value in its original place
		SortingService.exchange(a, i+1, high);
		return i+1;
	}

}
