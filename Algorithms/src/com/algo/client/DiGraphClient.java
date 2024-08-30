package com.algo.client;

import java.util.Arrays;
import java.util.List;

import com.algo.graph.DiGraph;
import com.algo.service.DigraphDepthFisrtSearchService;
import com.algo.service.GraphService;

public class DiGraphClient {

	public static void main(String[] args) {
		List<Integer> array = GraphService.readFileWithLineSpace("tinyDG.txt");
		DiGraph digraph = new DiGraph(array.get(0));
		int counter = 2;
		List<Integer> sourceList = Arrays.asList(1,2,6); 
		for (int i = 0; i < array.get(1); i++) {
			if (counter < array.size()) {
				int v = array.get(counter++);
				int w = array.get(counter++);
				digraph.addEdge(v, w);
			}
		}
		System.out.println(digraph.getAdjacencyList().toString());
		System.out.println("DiGraph has "+digraph.getVertices()+" Vertices!!!!");
		System.out.println("DiGraph has "+digraph.getEdges()+" Edges!!!!");
		for(int source : sourceList) {
			DigraphDepthFisrtSearchService dfsService = new DigraphDepthFisrtSearchService(digraph, source);
			for(int i=0;i<digraph.getVertices();i++) {
				if(dfsService.marked[i]) {
					System.out.println("Source "+source+" is connected to "+i);
				}
			}
		}
		
		
		
	}

}
