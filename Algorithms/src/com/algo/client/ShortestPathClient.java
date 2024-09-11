package com.algo.client;

import java.util.List;
import java.util.Stack;

import com.algo.model.DirectedEdge;
import com.algo.model.EdgeWeightedDigraph;
import com.algo.service.GraphService;
import com.algo.service.LongestPath;
import com.algo.service.ShortestPath;
import com.algo.service.TopologicalEdgeWeightedDigraphDFSService;

public class ShortestPathClient {

	public static void main(String[] args) {
		List<String> array = GraphService.readEdgeWeightedFileWithLineSpace("tinyEWDAG.txt");
		System.out.println("Graph has "+array.get(0)+" Vertices and "+array.get(1)+" Edges!!!!");
		EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(Integer.parseInt(array.get(0)));
		int counter = 2;
		int source=5;
		for (int i = 0; i < Integer.parseInt(array.get(1)); i++) {
			if (counter < array.size()) {
				int v = Integer.parseInt(array.get(counter++));
				int w = Integer.parseInt(array.get(counter++));
				double weight=Double.parseDouble(array.get(counter++));
				DirectedEdge directedEdge=new DirectedEdge(v, w, weight);
				edgeWeightedDigraph.addEdge(directedEdge);
			}
		}
		for(int i=0;i<Integer.parseInt(array.get(0));i++) {
			System.out.println("Graph adjacency matrix : "+edgeWeightedDigraph.edges().get(i));
		}
		
		TopologicalEdgeWeightedDigraphDFSService digraphDFSService = new TopologicalEdgeWeightedDigraphDFSService(edgeWeightedDigraph);
		Stack<Integer> reversePost=digraphDFSService.reversePost();
		while(!reversePost.isEmpty()) {
			System.out.println(reversePost.pop());
		}
		
		ShortestPath shortestPath = new ShortestPath(edgeWeightedDigraph, source);
		for(int i=0;i<edgeWeightedDigraph.vertices();i++) {
			System.out.print("Edge from "+source+" to "+i+" is ");
			System.out.print(shortestPath.pathTo(i)+" Weight is : "+shortestPath.weight());
			System.out.println();
		}
		
		LongestPath longestPath = new LongestPath(edgeWeightedDigraph, source);
		System.out.println("Longest path!!!!!!!!!!!!!!");
		for(int i=0;i<edgeWeightedDigraph.vertices();i++) {
			System.out.print("Edge from "+source+" to "+i+" is ");
			System.out.print(longestPath.pathTo(i)+" Weight is : "+longestPath.weight());
			System.out.println();
		}

	}

}
