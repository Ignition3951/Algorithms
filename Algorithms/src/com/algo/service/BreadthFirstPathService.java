package com.algo.service;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.algo.graph.Graph;

public class BreadthFirstPathService{
	
	public boolean[] marked;
	public int count;
	public int[] edgeTo;
	public int source;
	
	public BreadthFirstPathService(Graph g,int source) {
		marked = new boolean[g.V];
		edgeTo = new int[g.V];
		this.source=source;
		bfs(g,source);
	}

	public void bfs(Graph g, int source) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(source);
		marked[source] = true;
		while (!queue.isEmpty()) {
			source=queue.remove();
			for (int w : g.adj.get(source)) {
				if (!hasPathTo(w)) {
					edgeTo[w] = source;
					marked[w] = true;
					queue.add(w);
				}
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
