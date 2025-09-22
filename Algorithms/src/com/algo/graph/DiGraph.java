package com.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class DiGraph {

	private int V;
	private int E;
	private List<List<Integer>> adj;

	public DiGraph(int vertices) {
		this.V=vertices;
		this.E=0;
		adj= new ArrayList<List<Integer>>();
		for(int i=0;i<vertices;i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int v,int w) {
		List<Integer> innerlist = adj.get(v);
		if(innerlist==null) {
			innerlist=new ArrayList<Integer>(); 
		}
		innerlist.add(w);
		adj.set(v, innerlist);
		this.E++;
	}
	
	public List<List<Integer>> getAdjacencyList() {
		return this.adj;
	}
	
	public int getVertices() {
		return this.V;
	}
	
	public int getEdges() {
		return this.E;
	}

}
