package com.algo.service;

public class InsertionSortService implements SortingService {

	@Override
	public void sort(String[] a) {
		long start=System.currentTimeMillis();
		int N=a.length;
		for(int i=1;i<N;i++) {
			for(int j=i;j>0 && SortingService.less(a[j], a[j-1]);j--) {
				SortingService.exchange(a, j, j-1);
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("Time elapsed in InsertionSortService is : "+(end-start));
	}

}
