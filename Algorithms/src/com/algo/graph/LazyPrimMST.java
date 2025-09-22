package com.algo.graph;

import java.util.PriorityQueue;
import java.util.Queue;

import com.algo.model.Edge;

public class LazyPrimMST {
	
	private Queue<Edge> mst;
	private Queue<Edge> pq;
	private boolean marked[];
	
	public LazyPrimMST(EdgeWeightedGraph edgeWeightedGraph) {
		mst=new PriorityQueue<Edge>();
		pq=new PriorityQueue<Edge>();
		marked = new boolean[edgeWeightedGraph.vertices()];
		visit(edgeWeightedGraph,0);
		while(!pq.isEmpty()) {
			Edge e = pq.remove();
			int v=e.either();
			int w=e.other(v);
			if(marked[v] && marked[w]) continue;
			mst.add(e);
			if(!marked[v]) visit(edgeWeightedGraph,v);
			if(!marked[w]) visit(edgeWeightedGraph,w);
		}
	}

	private void visit(EdgeWeightedGraph edgeWeightedGraph, int source) {
		marked[source]=true;
		for(Edge e: edgeWeightedGraph.adjacecnycMatrix().get(source)) {
			if(!marked[e.other(source)]) {
				pq.add(e);
			}
		}
	}
	
	public double weight() {
		double weight = 0.0;
		for(Edge e: mst) {
			weight+=e.weight();
		}
		return weight;
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}

}
