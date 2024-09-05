package com.algo.fundamentals;

public class UnionFind {

	private int[] id;
	private int count;

	public UnionFind(int vertices) {
		id = new int[vertices];
		count = vertices;
		for (int i = 0; i < vertices; i++) {
			id[i] = i;
		}
	}

	public int find(int p) {
		return id[p];
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);

		if (pId == qId)
			return;

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId)
				id[i] = qId;
		}
		count--;
	}

	public int count() {
		return count;
	}
}
