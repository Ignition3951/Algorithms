package com.algo.graph;

import java.util.ArrayList;
import java.util.List;

import com.algo.service.GraphService;
import com.algo.service.SortingService;

public class Graph {

	public final int V;
	private int E;
	public List<List<Integer>> adj;

	public Graph(int v) {
		this.V = v;
		this.E = 0;
		adj = new ArrayList<List<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int v, int w) {
		List<Integer> forV = adj.get(v);
		if(forV==null) {
			forV=new ArrayList<Integer>();
		}
		forV.add(w);
		List<Integer> forW = adj.get(w);
		if(forW==null) {
			forW=new ArrayList<Integer>();
		}
		forW.add(v);
		adj.set(v, forV);
		adj.set(w, forW);
		E++;
	}

}
