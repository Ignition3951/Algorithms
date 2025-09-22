package com.algo.string.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface StringService {

	public static final String NEWLINE = System.getProperty("line.separator");

	static Map<String, Integer> convertFileToStringMap(String inputFilename, String delimiter) {
		Map<String, Integer> mapOfString = new HashMap<String, Integer>();
		try (Scanner sc = new Scanner(new File(inputFilename))) {
			sc.useDelimiter(NEWLINE);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] nodes = line.split(delimiter);
				mapOfString.put(nodes[0], Integer.parseInt(nodes[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mapOfString;
	}

	static int[] computeFrequencyCounts(Map<String, Integer> mapOfStrings) {
		int[] count = new int[mapOfStrings.size()];
		Arrays.fill(count, 0);
		for (String str : mapOfStrings.keySet()) {
			count[mapOfStrings.get(str) + 1]++;
		}
		return count;
	}

	static int[] transformCountToIndeces(int[] count, int vertices) {
		for (int i = 0; i < vertices - 1; i++) {
			count[i + 1] += count[i];
		}
		return count;
	}

	static String[] distributeTheData(int[] convertedCount, Map<String, Integer> mapOfString) {
		String[] aux = new String[mapOfString.size()];
		Arrays.fill(aux, null);
		for (String key : mapOfString.keySet()) {
			int value = mapOfString.get(key);
			aux[convertedCount[value]++] = key;
		}
		return aux;
	}
	
	static String[] convertFileToStringArray(String inputFilename, String delimiter) {
		String[] arrayOfString=new String[256];
		int counter=0;
		try (Scanner sc = new Scanner(new File(inputFilename))) {
			sc.useDelimiter(NEWLINE);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] nodes = line.split(delimiter);
				for(String node: nodes) {
					arrayOfString[counter++]=node;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] array=Arrays.copyOfRange(arrayOfString, 0, counter);
		return array;
	}
	
	static int[] computeFrequencyCountsInArray(String[] arrayOfStrings,int w) {
		int[] count = new int[256];
		Arrays.fill(count, 0);
		for (String str : arrayOfStrings) {
			count[str.charAt(w) + 1]++;
		}
		return count;
	}
	
	static String[] distributeTheDataInArray(int[] convertedCount, String[] arrayOfString,
			int w) {
		String[] aux = new String[arrayOfString.length];
		Arrays.fill(aux, null);
		for (String key : arrayOfString) {
			char value = key.charAt(w);
			aux[convertedCount[value]++] = key;
		}
		return aux;
	}
}
