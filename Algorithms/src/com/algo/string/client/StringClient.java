package com.algo.string.client;

import java.util.Map;

import com.algo.string.service.StringService;

public class StringClient {

	public static void main(String[] args) {
		Map<String, Integer> mapOfStrings = StringService.convertFileToStringMap("inputIndexedString.txt", " ");
		System.out.println(mapOfStrings.toString());
		int[] count = StringService.computeFrequencyCounts(mapOfStrings);
		System.out.print("Frequency Count Array : ");
		for (int temp : count) {
			System.out.print(temp + " ");
		}
		System.out.println();
		System.out.print("Converted Count Array : ");
		int[] convertedCount = StringService.transformCountToIndeces(count, mapOfStrings.size());
		for (int temp : convertedCount) {
			System.out.print(temp + " ");
		}
		System.out.println();
		System.out.print("Distributed Array : ");
		String[] distributedArray = StringService.distributeTheData(convertedCount, mapOfStrings);
		for (String temp : distributedArray) {
			System.out.print(temp + " ");
		}
	}

}
