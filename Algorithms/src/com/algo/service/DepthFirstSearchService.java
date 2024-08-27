package com.algo.service;

import com.algo.graph.Graph;

public class DepthFirstSearchService {
	
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearchService(Graph g,int source) {
		marked = new boolean[g.V];
		dfs(g,source);
	}

	private void dfs(Graph g, int source) {
		marked[source] = true;
		count++;
		for(int w: g.adj.get(source)) {
			if(!marked[w]) dfs(g,w);
		}
	}
	
	public boolean marked(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}

}
