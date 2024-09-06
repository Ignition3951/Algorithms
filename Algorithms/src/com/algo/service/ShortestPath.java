package com.algo.service;

import java.util.List;
import java.util.Stack;

import com.algo.graph.EdgeWeightedGraph;
import com.algo.model.DirectedEdge;
import com.algo.model.EdgeWeightedDigraph;

public class ShortestPath {
	
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	
	public ShortestPath(EdgeWeightedDigraph edgeWeightedDigraph,int source) {
		edgeTo = new DirectedEdge[edgeWeightedDigraph.vertices()];
		distTo = new double[edgeWeightedDigraph.vertices()];
		marked=new boolean[edgeWeightedDigraph.vertices()];
		edgeTo[0]=null;
		distTo[0]=Double.POSITIVE_INFINITY;
		for(int i=0;i<edgeWeightedDigraph.vertices();i++) {
			marked[i]=false;
		}
		shortestPath(edgeWeightedDigraph,source);
	}

	private void shortestPath(EdgeWeightedDigraph edgeWeightedDigraph, int source) {
		marked[source] = true;
		for(DirectedEdge directedEdge: edgeWeightedDigraph.edges().get(source)) {
			if(!hasPathTo(directedEdge.to())) {
				edgeTo[directedEdge.to()]=directedEdge;
				shortestPath(edgeWeightedDigraph, directedEdge.to());
			}
			
		}
		
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public DirectedEdge[] edgeTo(){
		return edgeTo;
	}
	
	public Iterable<DirectedEdge> pathTo(int destination){
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		if(edgeTo[destination]==null) return null;
		if(hasPathTo(destination)) {
			DirectedEdge edge=edgeTo[destination];
			for(DirectedEdge x=edgeTo[destination];x!=null;x=edgeTo[x.from()]) {
				path.push(x);
			}
		}
		return path;
	}
	

}
