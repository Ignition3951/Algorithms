package com.algo.graph;

import java.util.ArrayList;
import java.util.List;

import com.algo.model.Edge;

public class MST {
	
	private EdgeWeightedGraph edgeWeightedGraph;
	
	private List<Edge> edges;
	
	public MST(EdgeWeightedGraph edgeWeightedGraph) {
		this.edgeWeightedGraph=edgeWeightedGraph;
	}
	
	public Iterable<Edge> edges(){
		edges= new ArrayList<Edge>();
		Edge maxEdge =null;
		for(int i=0;i<edgeWeightedGraph.vertices();i++) {
			double weight=1.0;
			for(Edge edge: edgeWeightedGraph.adjacecnycMatrix().get(i)) {
				if(edge.weight()<weight && !edges.contains(edge)) {
					maxEdge=edge;
					weight=edge.weight();
				}
			}
			edges.add(maxEdge);
		}
		return edges;
	}
	
	public double weight() {
		double weight=0.0;
		for(int i=0;i<edgeWeightedGraph.vertices();i++) {
			weight=weight+edges.get(i).weight();
		}
		return weight;
	}

}
