package com.algo.model;

import java.util.PriorityQueue;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	private class Node {
		private int N;
		private Node left, right;
		private Key key;
		private Value value;

		public Node(int N, Key key, Value value) {
			this.N = N;
			this.key = key;
			this.value = value;
		}

	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if (x==null) return 0;
		else return x.N;
	}
	
	public Value get(Key key) {
		return get(root,key);
	}
	
	private Value get(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else return x.value;
	}
	
	public void put(Key key,Value value) {
		root = put(root,key,value);
	}
	
	private Node put(Node x,Key key,Value value) {
		if(x==null) return new Node(1, key, value);
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left=put(x.left,key,value);
		else if(cmp>0) x.right=put(x.right,key,value);
		else x.value=value;
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
	
	public Iterable<Key> keys(){
		Queue<Key> queue = new PriorityQueue<Key>() ;
		keys(root,queue);
		return queue;
		
	}

	private void keys(Node root, Queue<Key> queue) {
		if(root==null) return;
		keys(root.left,queue);
		keys(root.right,queue);
		queue.offer(root.key);
		
	}
	
	public Key min() {
		return min(root).key;
	}
	
	private Node min(Node x) {
		if(x.left==null) return x;
		return min(x.left);
	}
	
	public Key floor(Key key) {
		Node x=floor(root,key);
		if(x==null) return null;
		return x.key;
	}
	
	private Node floor(Node x,Key key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp<0) return floor(x.left,key);
		Node t = floor(x.right,key);
		if(t!=null) return t;
		else return x;
	}
	
	public Key ceiling(Key key) {
		Node x=ceiling(root,key);
		if(x==null) return null;
		return x.key;
	}
	
	private Node ceiling(Node x,Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp>0) return ceiling(x.right,key);
		Node t=ceiling(x.left,key);
		if(t!=null) return t;
		else return x;
	}

}
