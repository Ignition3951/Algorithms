package com.algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.algo.service.DirectedCycle;
import com.algo.service.GraphService;
import com.algo.service.TopologicalDepthFirstSearchService;

public class SymbolGraph {
	
//	private Map<String, Integer> st;

	public static void main(String[] args) {
		Map<String, Integer> mapOfJobs = GraphService.convertFileToSymbolGraphMap("jobs.txt", "/");
		System.out.println(mapOfJobs.toString());
		List<String> verticesValue=new ArrayList<String>();
		for(int a=0;a<=mapOfJobs.size();a++) {
			verticesValue.add(a,null);
		}
		for(String i: mapOfJobs.keySet()) {
		verticesValue.set(mapOfJobs.get(i), i);
		}
		DiGraph diGraph = GraphService.convertFileToDiGraph("jobs.txt", "/", mapOfJobs);
		System.out.println("Adjacency matrix is : "+diGraph.getAdjacencyList().toString());
		DirectedCycle cyclefinder = new DirectedCycle(diGraph);
		if (cyclefinder.hasCycle())
		 {
			for(int v: cyclefinder.cycle()) {
				System.out.println("Cycle found : "+v);}
		 }
		if (!cyclefinder.hasCycle())
		 {
			TopologicalDepthFirstSearchService dfs = new TopologicalDepthFirstSearchService(diGraph,0);
			Stack<Integer> reversePost= dfs.reversePost();
			while(!reversePost.isEmpty()) {
				System.out.println(verticesValue.get(reversePost.pop()));
			}
		 }
	}
}
