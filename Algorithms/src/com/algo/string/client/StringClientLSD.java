package com.algo.string.client;

import com.algo.string.service.StringService;
import com.algo.string.service.StringSortService;
import com.algo.string.service.impl.LSD;

public class StringClientLSD {

	public static void main(String[] args) {
		String[] arrayOfStrings = StringService.convertFileToStringArray("words3.txt", " ");
		System.out.println(" Array of words3.txt");
		for (String temp : arrayOfStrings) {
			System.out.print(temp + " ");
		}
		StringSortService sortService = new LSD();
		sortService.sort(arrayOfStrings, 3);
	}

}
