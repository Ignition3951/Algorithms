package com.algo.service;

public class ShellSortingService implements SortingService {

	@Override
	public void sort(String[] a) {
		//Shell  sorting using sequence of decreasing values ½(3powerk-1)
		//starting at the largest increment less than N/3 and decreasing to 1
		int N=a.length;
		int h=1;
		while(h<N/3) {
			h=3*h+1;
		}
		while(h>=1) {
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h && SortingService.less(a[j], a[j-h]);j-=h){
					SortingService.exchange(a, j, j-h);
				}
			}
			System.out.print(h+":Sorting --> ");
			SortingService.show(a);
			System.out.println();
			h=h/3;
		}
	}

}
