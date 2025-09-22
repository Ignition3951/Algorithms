package com.algo.model;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeparateChainingHashST<Key,Value> {

	private int N;
	private int M;
	
	private ST<Key, Value>[] st;
	
	public SeparateChainingHashST() {
		this(997);
	}
	
	public SeparateChainingHashST(int M){
		this.M=M;
		st= (ST<Key, Value>[]) new ST[M];
		for(int i=0;i<M;i++) {
			st[i]=new ST();
		}
	}
	
	private int hash(Key key) {
		return (key.hashCode() &  0x7fffffff) % M;
	}
	
	public Value get(Key key) {
		return (st[hash(key)].get(key));
	}
	
	public void put(Key key,Value value) {
		st[hash(key)].put(key, value);
	}
	
	public Iterable<Key> keys(){
		Queue<Key> keys = new PriorityQueue<Key>();
		for(int i=0;i<M;i++) {
			for(Key key: st[i].keys()) {
				keys.offer(key);
			}
		}
		return keys;
	}
}
