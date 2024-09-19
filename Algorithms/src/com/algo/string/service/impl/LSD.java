package com.algo.string.service.impl;

import com.algo.string.service.StringService;
import com.algo.string.service.StringSortService;
import com.algo.util.Constants;

public class LSD implements StringSortService {

	@Override
	public void sort(String[] arrayOfString, int w) {
		int R = Constants.radix;
		for (int d = w - 1; d >= 0; d--) {
			int[] count = StringService.computeFrequencyCountsInArray(arrayOfString, d);
			int[] convertedCount = StringService.transformCountToIndeces(count, R);
			arrayOfString = StringService.distributeTheDataInArray(convertedCount, arrayOfString, d);
		}
		for(String sort: arrayOfString) {
			if(sort!=null) {
				System.out.print(sort + " ");
			}
		}

	}

}
