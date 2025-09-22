package com.algo.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface SortingService {
	
	static void exchange(Comparable[] a, int firstSwap, int secondSwap) {
		Comparable t=a[firstSwap];
		a[firstSwap] = a[secondSwap];
		a[secondSwap] = t;
	}
	
	static boolean less(Comparable a, Comparable b) {
		//a is less than b
		return a.compareTo(b)<0;
	}
	
	public void sort(String[] a);
	
	static boolean isSortedAsc(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}
	
	static void show(Comparable[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}

	}
	
	static void writeToFile(String outputFileName) {
		try {
			PrintWriter pw=new PrintWriter(new
			            BufferedWriter(new FileWriter(outputFileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String[] readFileWithNewline(String inputFilename) {
		List<String>  strings = new ArrayList<String>();
		try {
			
			BufferedReader br = new BufferedReader( 
			        new FileReader(inputFilename));
			String line;
			while((line = br.readLine()) != null) {
				strings.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		 String[] array = strings.toArray(new String[0]);
		 return array;
	}
	
	static String[] readFileWithLineSpace(String inputFilename) {
		List<String> listOfStrings = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(inputFilename))) {
            sc.useDelimiter("\\s+"); // Use space as delimiter
            while (sc.hasNext()) {
                listOfStrings.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] array = listOfStrings.toArray(new String[0]);
        return array;
    }

}
