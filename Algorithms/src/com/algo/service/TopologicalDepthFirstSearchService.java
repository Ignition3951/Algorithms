package com.algo.service;

import java.util.Stack;

import com.algo.graph.DiGraph;

public class TopologicalDepthFirstSearchService {

	public boolean[] marked;
	public int count = 0;
	private Stack<Integer> reversePost;

	public TopologicalDepthFirstSearchService() {
	}

	public TopologicalDepthFirstSearchService(DiGraph dg, int source) {
		marked = new boolean[dg.getVertices()];
		reversePost = new Stack<Integer>();
		for (int i = 0; i < dg.getVertices(); i++) {
			if (!marked[i])
				dfs(dg, i);
		}
	}

	public void dfs(DiGraph dg, int source) {
		marked[source] = true;
		count++;
		for (int w : dg.getAdjacencyList().get(source)) {
			if (!marked[w])
				dfs(dg, w);
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
