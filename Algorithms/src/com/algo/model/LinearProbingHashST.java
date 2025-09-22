package com.algo.model;

import java.util.PriorityQueue;
import java.util.Queue;

public class LinearProbingHashST<Key,Value> {
	
	private int N;
	private int M=16;
	private Key[] keys;
	private Value[] values;
	
	public LinearProbingHashST() {
		this(4);
		}

	public LinearProbingHashST(int capacity) {
		M=capacity;
		N=0;
		keys= (Key[]) new Object[M];
		values= (Value[]) new Object[M];
	}
	
	private int hash(Key key) {
		return (key.hashCode() &  0x7fffffff) % M;
	}
	
	public void resize(int capacity) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST(capacity);
		for(int i=0;i<M;i++) {
			if(keys[i]!=null) {
				temp.put(keys[i], values[i]);
			}
		}
		keys=temp.keys;
		values=temp.values;
		M=temp.M;
	}
	
	public void put(Key key,Value value) {
		if(N>=M/2) resize(2*M);
		int i;
		for(i=hash(key);keys[i]!=null;i=(i+1)%M) {
			if(keys[i].equals(key)) {
				values[i]=value;
				return;
			}
		}
		keys[i]=key;
		values[i]=value;
		N++;
	}
	
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (keys[i].equals(key)) {
				return values[i];
			}
		}
		return null;
	}
	
	public Iterable<Key> keys(){
		Queue<Key> queue = new PriorityQueue<Key>();
		for(int i=0;i<M;i++) {
			if(keys[i]!=null) {
				queue.offer(keys[i]);
			}
		}
		return queue;
	}

}
