package com.algo.action;

import com.algo.service.InsertionSortService;
import com.algo.service.SelectionSortingService;
import com.algo.service.ShellSortingService;
import com.algo.service.SortingService;

public class Chapter2 {

	public static void main(String[] args) {
		
		String[] array = SortingService.readFileWithLineSpace("tiny.txt");
//		 SelectionSortingService selectionSortingService = new SelectionSortingService();
//		 selectionSortingService.sort(array);
//		InsertionSortService insertionSortService = new InsertionSortService();
//		insertionSortService.sort(array);
		ShellSortingService shellSortingService = new ShellSortingService();
		shellSortingService.sort(array);
		 SortingService.show(array);
	}
}
