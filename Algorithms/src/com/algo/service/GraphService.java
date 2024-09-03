package com.algo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.algo.graph.DiGraph;

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

	static List<String> readFileWithDelimiter(String inputFilename, String delimiter) {
		List<String> listOfStrings = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(inputFilename))) {
			sc.useDelimiter(delimiter);
			while (sc.hasNext()) {
				listOfStrings.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listOfStrings;
	}

	static Map<String, Integer> convertFileToSymbolGraphMap(String inputFilename, String delimiter) {
		Map<String, Integer> mapOfJobs = new HashMap<String, Integer>();
		try (Scanner sc = new Scanner(new File(inputFilename))) {
			sc.useDelimiter(NEWLINE);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] nodes = line.split(delimiter);
				for (int i = 0; i < nodes.length; i++) {
					if (!mapOfJobs.containsKey(nodes[i])) {
						mapOfJobs.put(nodes[i], mapOfJobs.size());
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mapOfJobs;
	}

	static DiGraph convertFileToDiGraph(String inputFilename, String delimiter,
			Map<String, Integer> mapOfJobs) {
		DiGraph diGraph=new DiGraph(mapOfJobs.size());
		try (Scanner sc = new Scanner(new File(inputFilename))) {
			sc.useDelimiter(NEWLINE);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] nodes = line.split(delimiter);
				for (int i = 1; i < nodes.length; i++) {
					diGraph.addEdge(mapOfJobs.get(nodes[0]), mapOfJobs.get(nodes[i]));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return diGraph;
	}
}
