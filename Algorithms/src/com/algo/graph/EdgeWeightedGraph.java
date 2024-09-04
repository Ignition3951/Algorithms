package com.algo.graph;

import java.util.ArrayList;
import java.util.List;

import com.algo.model.Edge;

public class EdgeWeightedGraph {

	private int V;
	private int E;
	private List<List<Edge>> adjacency;

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adjacency = new ArrayList<List<Edge>>(V);
		for (int i = 0; i < V; i++) {
			adjacency.add(new ArrayList<Edge>());
		}
	}
	
	public void addEdge(Edge edge) {
		int v=edge.either(),w=edge.other(v);
		List<Edge> forV = adjacency.get(v);
		if(forV==null) {
			forV=new ArrayList<Edge>();
		}
		forV.addFirst(edge);
		List<Edge> forW = adjacency.get(w);
		if(forW==null) {
			forW=new ArrayList<Edge>();
		}
		forW.addFirst(edge);
	}
	
	public List<List<Edge>> adjacecnycMatrix() {
		return this.adjacency;
	}
	
	public int vertices() {
		return this.V;
	}

}
