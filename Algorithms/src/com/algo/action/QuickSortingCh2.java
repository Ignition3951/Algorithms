package com.algo.action;

import com.algo.service.QuickSortService;
import com.algo.service.SortingService;

public class QuickSortingCh2 {

	public static void main(String[] args) {
		String[] array = SortingService.readFileWithLineSpace("tiny.txt");
		QuickSortService quickSortService = new QuickSortService();
		quickSortService.sort(array);
		SortingService.show(array);
		
	}

}
