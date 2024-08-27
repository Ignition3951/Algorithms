package com.algo.client;

import java.util.List;

import com.algo.graph.Graph;
import com.algo.service.DepthFirstSearchService;
import com.algo.service.GraphService;

public class GraphClient {

	public static void main(String[] args) {
		List<Integer> array = GraphService.readFileWithLineSpace("tinyG.txt");
		System.out.println("Graph has "+array.get(0)+" Vertices and "+array.get(1)+" Edges!!!!");
		Graph graph = new Graph(array.get(0));
		int source=0;
		int counter = 2;
		for (int i = 0; i < array.get(1); i++) {
			if (counter < array.size()) {
				int v = array.get(counter++);
				int w = array.get(counter++);
				graph.addEdge(v, w);
			}
		}
		DepthFirstSearchService service = new DepthFirstSearchService(graph, source);
		System.out.print("Source : "+source+" is connected (directly/indirectly) to vertices: ");
		for(int j=0;j<graph.V;j++) {
			if(service.marked(j)) System.out.print(" "+j);
		}
		System.out.println();
		
		if(service.count()==graph.V) System.out.println("Graph is connected!!!!!");
		else System.out.println("Graph is not connected!!!!!");
		
		for (int i = 0; i < graph.V; i++) {
			System.out.println("Vertex : "+i+" is connected directly to "+graph.adj.get(i)+" Vertices!!!");
		}
	}

}
