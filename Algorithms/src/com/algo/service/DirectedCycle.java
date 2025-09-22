package com.algo.service;

import java.util.Stack;

import com.algo.graph.DiGraph;

public class DirectedCycle {
	
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	
	public DirectedCycle(DiGraph digraph) {
		marked = new boolean[digraph.getVertices()];
		edgeTo = new int[digraph.getVertices()];
		onStack = new boolean[digraph.getVertices()];
		for(int i=0;i<digraph.getVertices();i++) {
			dfs(digraph,i);
		}
	}

	private void dfs(DiGraph digraph, int source) {
		marked[source] = true;
		onStack[source] = true;
		for(int w: digraph.getAdjacencyList().get(source)) {
			if(hasCycle()) return;
			if(!marked[w]) {
				edgeTo[w]=source;
				dfs(digraph, w);
			}else if(onStack[w]) {
				cycle= new Stack<Integer>();
				for(int x=source;x!=w;x=edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(source);
			}
			
		}
		onStack[source] = false;
		
	}
	
	public boolean hasCycle() {
		return cycle !=null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}

}
