package com.algo.client;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.algo.graph.EdgeWeightedGraph;
import com.algo.graph.Graph;
import com.algo.graph.LazyPrimMST;
import com.algo.graph.MST;
import com.algo.model.Edge;
import com.algo.service.GraphService;

public class EdgeGraphClient {

	public static void main(String[] args) {
		List<String> array = GraphService.readEdgeWeightedFileWithLineSpace("tinyEWG.txt");
		System.out.println("Graph has "+array.get(0)+" Vertices and "+array.get(1)+" Edges!!!!");
		EdgeWeightedGraph graph = new EdgeWeightedGraph(Integer.parseInt(array.get(0)));
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
		
		MST mst = new MST(graph);
		for(Edge edge: mst.edges()) {
			System.out.println(edge);
		}
		System.out.println("Weigth of MST is : "+mst.weight());
		
		LazyPrimMST primMST = new LazyPrimMST(graph);
		for(Edge edge: primMST.edges()) {
			System.out.println(edge);
		}
		System.out.println("Weigth of LazyPrimMST is : "+primMST.weight());
	}

}
