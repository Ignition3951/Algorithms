package com.algo.service;

import java.util.Stack;

import com.algo.model.DirectedEdge;
import com.algo.model.EdgeWeightedDigraph;

public class TopologicalEdgeWeightedDigraphDFSService {
	
	public boolean[] marked;
	public int count = 0;
	private Stack<Integer> reversePost;

	public TopologicalEdgeWeightedDigraphDFSService() {
	}

	public TopologicalEdgeWeightedDigraphDFSService(EdgeWeightedDigraph dg) {
		marked = new boolean[dg.vertices()];
		reversePost = new Stack<Integer>();
		for (int i = 0; i < dg.vertices(); i++) {
			if (!marked[i])
				dfs(dg, i);
		}
	}

	public void dfs(EdgeWeightedDigraph dg, int source) {
		marked[source] = true;
		count++;
		for (DirectedEdge w : dg.edges().get(source)) {
			if (!marked[w.to()])
				dfs(dg, w.to());
		}
		reversePost.push(source);
	}

	public boolean marked(int w) {
		return marked[w];
	}

	public int count() {
		return count;
	}

	public Stack<Integer> reversePost() {
		return reversePost;
	}

}
