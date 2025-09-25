package com.algo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.algo.model.Edge;

public class KruskalEdgeWeightedGraph extends EdgeWeightedGraph {
	
	private Queue<Edge> edges;
	
	public KruskalEdgeWeightedGraph(int vertices) {
		super(vertices);
		edges=new PriorityQueue<Edge>();
	}
	
	@Override
	public void addEdge(Edge edge) {
		super.addEdge(edge);
		edges.add(edge);
	}
	
	public Queue<Edge> edges() {
		return edges;
	}

}
