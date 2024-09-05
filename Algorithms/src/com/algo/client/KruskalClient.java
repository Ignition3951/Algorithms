package com.algo.client;

import java.util.List;

import com.algo.graph.EdgeWeightedGraph;
import com.algo.graph.KruskalEdgeWeightedGraph;
import com.algo.graph.KruskalMST;
import com.algo.graph.LazyPrimMST;
import com.algo.graph.MST;
import com.algo.model.Edge;
import com.algo.service.GraphService;

public class KruskalClient {

	public static void main(String[] args) {
		List<String> array = GraphService.readEdgeWeightedFileWithLineSpace("tinyEWG.txt");
		System.out.println("Graph has "+array.get(0)+" Vertices and "+array.get(1)+" Edges!!!!");
		KruskalEdgeWeightedGraph graph = new KruskalEdgeWeightedGraph(Integer.parseInt(array.get(0)));
		int source=0;
		int counter = 2;
		for (int i = 0; i < Integer.parseInt(array.get(1)); i++) {
			if (counter < array.size()) {
				int v = Integer.parseInt(array.get(counter++));
				int w = Integer.parseInt(array.get(counter++));
				double weight=Double.parseDouble(array.get(counter++));
				Edge edge=new Edge(v, w, weight);
				graph.addEdge(edge);
			}
		}
		for(int i=0;i<Integer.parseInt(array.get(0));i++) {
			System.out.println("Graph adjacency matrix : "+graph.adjacecnycMatrix().get(i));
		}
		
		KruskalMST kruskalMST = new KruskalMST(graph);
		for(Edge edge: kruskalMST.edges()) {
			System.out.println(edge);
		}
		System.out.println("Weigth of KruskalMST is : "+kruskalMST.weight());

	}

}
