package com.algo.service;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.algo.graph.DiGraph;

public class DigraphDepthFisrtSearchService extends DepthFirstSearchService{
	
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DigraphDepthFisrtSearchService(DiGraph dg, int source) {
		pre=new PriorityQueue<Integer>();
		post=new PriorityQueue<Integer>();
		reversePost=new Stack<Integer>();
		marked = new boolean[dg.getVertices()];
		dfs(dg, source);
		
	}
	
	public void dfs(DiGraph dg, int source) {
		pre.add(source);
		marked[source] = true;
			for(int w: dg.getAdjacencyList().get(source)) {
				if(!marked[w]) {
					dfs(dg,w);
				}
			}
		post.add(source);
		reversePost.add(source);
	}
	
	public Iterable<Integer> pre(){
		return pre;
	}
	
	public Iterable<Integer> post(){
		return post;
	}
	
	public Iterable<Integer> reversePost(){
		return reversePost;
	}


}
