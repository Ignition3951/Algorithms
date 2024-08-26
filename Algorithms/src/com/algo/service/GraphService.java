package com.algo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface GraphService {
	public static final String NEWLINE = System.getProperty("line.separator");

	static List<Integer> readFileWithLineSpace(String inputFilename) {
		List<Integer> listOfStrings = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(inputFilename))) {
            sc.useDelimiter("\\s+"); // Use space as delimiter
            while (sc.hasNextInt()) {
                listOfStrings.add(sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfStrings;
    }
}
