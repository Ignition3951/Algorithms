package com.algo.action;

import com.algo.service.MergeSortingService;
import com.algo.service.SortingService;

public class MergeSortingChp2 {

	public static void main(String[] args) {
		String[] array = SortingService.readFileWithLineSpace("tiny.txt");
		MergeSortingService mergeSortingService = new MergeSortingService();
		mergeSortingService.sort(array);
		SortingService.show(array);
	}
}
