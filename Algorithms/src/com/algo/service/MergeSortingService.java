package com.algo.service;

public class MergeSortingService implements SortingService {

	@Override
	public void sort(String[] a) {
		int N=a.length;
		sort(a,0,N-1);

	}
	
	public void sort(String[] a,int low,int high) {
		if(high<=low) return;
		int mid=low+(high-low)/2;
		sort(a,low,mid);
		sort(a,mid+1,high);
		mergeSort(a, low, mid, high);
		
	}
	
	public void mergeSort(String[] a,int low,int mid,int high) {
		//Calculating the sizes for both arrays
		int leftArraySize = mid-low+1;
		int rightArraySize=high-mid;
		
		//Initializing the arrays for the appropriate sizes
		String[] leftArray = new String[leftArraySize];
		String[] rightArray = new String[rightArraySize];
		
		for(int i=0;i<leftArraySize;i++) {
			leftArray[i]=a[low+i];
		}
		for(int j=0;j<leftArraySize;j++) {
			rightArray[j]=a[mid+j+1];
		}
		
		
		int k=low,i=0,j=0;
		while(i<leftArraySize && j<rightArraySize) {
			//Checking for whichever element is lower in comparison
			if(SortingService.less(leftArray[i], rightArray[j])) {
				a[k]=leftArray[i];
				i++;
			}else {
				a[k]=rightArray[j];
				j++;
			}
			k++;
		}
		
		//Adding the remaining elements as it is
		while(i<leftArraySize) {
			a[k]=leftArray[i];
			i++;
			k++;
		}
		
		while(j<rightArraySize) {
			a[k]=rightArray[j];
			j++;
			k++;
		}
	}

}
