package com.algo.service;

import com.algo.graph.Graph;

public class ComponentConnectedService {

	public int[] id;
	public boolean[] marked;
	public int count = 0;

	public ComponentConnectedService(Graph g, int source) {
		id = new int[g.V];
		marked = new boolean[g.V];
		for (int i = 0; i < g.V; i++) {
			if (!marked[i]) {
				dfs(g, i);
				count++;
			}
		}
	}

	public void dfs(Graph g, int source) {
		marked[source] = true;
		id[source] = count;
		for (int x : g.adj.get(source)) {
			if (!marked[x]) {
				dfs(g, x);
			}
		}
	}

}
