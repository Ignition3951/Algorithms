package com.algo.service;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.algo.model.DirectedEdge;
import com.algo.model.EdgeWeightedDigraph;

public class LongestPath{

	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private Queue<DirectedEdge> pq;
	private double weight;
	
	public LongestPath(EdgeWeightedDigraph edgeWeightedDigraph,int source) {
		edgeTo = new DirectedEdge[edgeWeightedDigraph.vertices()];
		distTo = new double[edgeWeightedDigraph.vertices()];
		pq=new PriorityQueue<DirectedEdge>();
		for(int i=0;i<edgeWeightedDigraph.vertices();i++) {
			distTo[i]=Double.NEGATIVE_INFINITY;
		}
		distTo[source]=0.0;
		for(DirectedEdge edge: edgeWeightedDigraph.edges().get(source)) {
			pq.add(edge);
		}
		relax(edgeWeightedDigraph,source);
		while(!pq.isEmpty()) {
			DirectedEdge edge=pq.remove();
			int destinationVertex=edge.to();
			relax(edgeWeightedDigraph,destinationVertex);
		}
		
	}

	public void relax(EdgeWeightedDigraph edgeWeightedDigraph, int destinationVertex) {
		for(DirectedEdge edge: edgeWeightedDigraph.edges().get(destinationVertex)) {
			int w=edge.to();
			if(distTo[w]<distTo[destinationVertex]+edge.weight()) {
				distTo[w]=distTo[destinationVertex]+edge.weight();
				edgeTo[w]=edge;
				pq.add(edge);
			}
			
		}
	}
	
	public boolean hasPathTo(int v) {
		return edgeTo[v]!=null;
	}
	
	public DirectedEdge[] edgeTo(){
		return edgeTo;
	}
	
	public Iterable<DirectedEdge> pathTo(int destination){
		weight=0.0;
		if(edgeTo[destination]==null) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		if(hasPathTo(destination)) {
			for(DirectedEdge x=edgeTo[destination];x!=null;x=edgeTo[x.from()]) {
				path.push(x);
				weight+=x.weight();
			}
		}
		return path;
	}
	
	public double weight() {
		double roundedValue=Math.round(weight*100.0)/100.0;
		return roundedValue;
	}
	
	public double[] distanceTo() {
		return distTo;
	}
	
	public Queue<DirectedEdge> getQueue(){
		return pq;
	}
}
