package com.algo.client;

import java.util.List;

import com.algo.graph.Graph;
import com.algo.service.GraphService;

public class GraphClient {

	public static void main(String[] args) {
		List<Integer> array = GraphService.readFileWithLineSpace("tinyCG.txt");
		System.out.println("Graph has "+array.get(0)+" Vertices and "+array.get(1)+" Edges!!!!");
		Graph graph = new Graph(array.get(0));
		int counter = 2;
		for (int i = 0; i < array.get(1); i++) {
			if (counter < array.size()) {
				int v = array.get(counter++);
				int w = array.get(counter++);
				graph.addEdge(v, w);
			}
		}
		
		for (int i = 0; i < graph.V; i++) {
			System.out.println("Vertex : "+i+" is connected to "+graph.adj.get(i)+" Vertices!!!");
		}
	}

}
