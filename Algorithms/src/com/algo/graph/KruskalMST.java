package com.algo.graph;

import java.util.PriorityQueue;
import java.util.Queue;

import com.algo.fundamentals.UnionFind;
import com.algo.model.Edge;

public class KruskalMST {

	private Queue<Edge> mst;

	public KruskalMST(KruskalEdgeWeightedGraph kruskalEdgeWeightedGraph) {
		mst = new PriorityQueue<Edge>();
		Queue<Edge> pq = new PriorityQueue<Edge>();
		UnionFind unionFind = new UnionFind(kruskalEdgeWeightedGraph.vertices());
		pq = kruskalEdgeWeightedGraph.edges();
		while (!pq.isEmpty() && mst.size() < kruskalEdgeWeightedGraph.vertices()) {
			Edge edge = pq.remove();
			int v = edge.either();
			int q = edge.other(v);

			if (unionFind.connected(v, q))
				continue;
			unionFind.union(v, q);
			mst.add(edge);
		}
	}

	public double weight() {
		double weight = 0.0;
		for (Edge e : mst) {
			weight += e.weight();
		}
		return weight;
	}

	public Iterable<Edge> edges() {
		return mst;
	}

}
