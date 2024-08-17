package com.algo.service;

public class SelectionSortingService implements SortingService {

	@Override
	public void sort(String[] a) {
		long start=System.currentTimeMillis();
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
		long end=System.currentTimeMillis();
		System.out.println("Time elapsed in SelectionSortingService is : "+(end-start));
	}
	
	
}
