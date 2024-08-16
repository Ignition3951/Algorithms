package com.algo.service;

public class MergeSortingService implements SortingService {

	@Override
	public void sort(String[] a) {
		int N = a.length;
		for(int i=0;i<N;i++) {
			int min=i;
			for(int j=i+1;j<N;j++) {
				if(SortingService.less(a[j],a[min])) {
					min=j;
				}
			}
			SortingService.exchange(a, i, min);
		}
	}
	
	
}
