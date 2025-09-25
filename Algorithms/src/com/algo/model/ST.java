package com.algo.model;

import java.util.ArrayList;
import java.util.List;

public class ST<Key, Value> {

	private Node first;

	private class Node {
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, ST<Key, Value>.Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				return x.value;
			}
		}
		return null;
	}

	public void put(Key key, Value value) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.value = value;
				return;
			}
		}
		first = new Node(key, value, first);
	}
	
	public List<Key> keys(){
		List<Key> keys = new ArrayList<Key>();
		for(Node x=first;x!=null;x=x.next) {
			keys.add(x.key);
		}
		return keys;
	}
}
