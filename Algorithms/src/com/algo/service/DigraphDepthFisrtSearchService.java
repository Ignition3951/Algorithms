package com.algo.service;

import com.algo.graph.DiGraph;

public class DigraphDepthFisrtSearchService extends DepthFirstSearchService{
	
	public DigraphDepthFisrtSearchService(DiGraph dg, int source) {
		marked = new boolean[dg.getVertices()];
		dfs(dg, source);
		
	}
	
	public void dfs(DiGraph dg, int source) {
		marked[source] = true;
			for(int w: dg.getAdjacencyList().get(source)) {
				if(!marked[w]) {
					dfs(dg,w);
				}
			}
	}


}
