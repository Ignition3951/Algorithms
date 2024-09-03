package com.algo.graph;

import java.util.List;
import java.util.Map;

import com.algo.service.DigraphDepthFisrtSearchService;
import com.algo.service.DirectedCycle;
import com.algo.service.GraphService;

public class SymbolGraph {
	
//	private Map<String, Integer> st;

	public static void main(String[] args) {
		Map<String, Integer> mapOfJobs = GraphService.convertFileToSymbolGraphMap("jobs.txt", "/");
		for(int i=0;i<mapOfJobs.size();i++) {
			for(String key: mapOfJobs.keySet()) {
				if(mapOfJobs.get(key)==i) {
					System.out.println("Key : "+key+" Value : "+i);
				}
			}
		}
		DiGraph diGraph = GraphService.convertFileToDiGraph("jobs.txt", "/", mapOfJobs);
		System.out.println("Adjacency matrix is : "+diGraph.getAdjacencyList().toString());
		DirectedCycle cyclefinder = new DirectedCycle(diGraph);
		Iterable<Integer> order=null;
		if (!cyclefinder.hasCycle())
		 {
		 DigraphDepthFisrtSearchService dfs = new DigraphDepthFisrtSearchService(diGraph,0);
		 order = dfs.reversePost();
		 }
		for(int v: order) {
			System.out.println("Key : "+v);
//			for(String key: mapOfJobs.keySet()) {
//				if(mapOfJobs.get(key)==v) {
//					System.out.println("Key : "+key+" Value : "+v);
//				}
//			}
		}
	}
}
