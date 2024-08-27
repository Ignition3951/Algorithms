package com.algo.service;

import java.util.Stack;

import com.algo.graph.Graph;

public class DepthFirstPathService {
	
	private boolean[] marked;
	private int count;
	private int[] edgeTo;
	private int source;
	
	public DepthFirstPathService(Graph g,int source) {
		marked = new boolean[g.V];
		edgeTo = new int[g.V];
		this.source=source;
		dfs(g,source);
	}

	private void dfs(Graph g, int source) {
		marked[source] = true;
		count++;
		for(int w: g.adj.get(source)) {
			if(!marked[w]) {
				//Record the value to backtrace the path from destination to source
				edgeTo[w]=source;
				dfs(g,w);
			}
		}
	}
	
	public boolean hasPathTo(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v;x!=source;x=edgeTo[x]) {
			path.push(x);
		}
		path.push(source);
		return path;
		
	}

}
