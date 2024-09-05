package com.algo.client;

import java.util.List;

import com.algo.fundamentals.UnionFind;
import com.algo.graph.Graph;
import com.algo.service.GraphService;

public class UnionFindClient {

	public static void main(String[] args) {
		List<Integer> array = GraphService.readFileWithLineSpace("tinyUF.txt");
		int vertices=array.get(0);
		int counter=1;
		UnionFind unionFind = new UnionFind(vertices);
		for(int i=0;i<vertices;i++) {
			int p=array.get(counter++);
			int q=array.get(counter++);
			
			if(unionFind.connected(p, q)) continue;
			unionFind.union(p, q);
			System.out.print("p : "+p+" q :"+q);
			System.out.println();
		}
		System.out.print(unionFind.count()+": components!!!!");
	}

}
