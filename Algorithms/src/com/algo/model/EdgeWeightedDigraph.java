package com.algo.model;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {

	private int vertices;
	private List<List<DirectedEdge>> adjacency;

	public EdgeWeightedDigraph(int vertices) {
		this.vertices = vertices;
		adjacency=new ArrayList<List<DirectedEdge>>();
		for(int i=0;i<vertices;i++) {
			adjacency.add(new ArrayList<DirectedEdge>());
		}
	}
	
	public void addEdge(DirectedEdge directedEdge) {
		List<DirectedEdge> innerlist=new ArrayList<DirectedEdge>();
		innerlist=adjacency.get(directedEdge.from());
		if(innerlist==null) {
			innerlist=new ArrayList<DirectedEdge>();
		}
		innerlist.add(directedEdge);
		adjacency.set(directedEdge.from(), innerlist);
	}
	
	public List<List<DirectedEdge>> edges(){
		return adjacency;
	}
	
	public int vertices() {
		return vertices;
	}

}
