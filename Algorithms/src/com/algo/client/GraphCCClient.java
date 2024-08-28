package com.algo.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.algo.graph.Graph;
import com.algo.service.ComponentConnectedService;
import com.algo.service.GraphService;

public class GraphCCClient {

	public static void main(String[] args) {
		List<Integer> array = GraphService.readFileWithLineSpace("tinyG.txt");
		System.out.println("Graph has "+array.get(0)+" Vertices and "+array.get(1)+" Edges!!!!");
		Graph graph = new Graph(array.get(0));
		int source=0;
		int counter = 2;
		for (int i = 0; i < array.get(1); i++) {
			if (counter < array.size()) {
				int v = array.get(counter++);
				int w = array.get(counter++);
				graph.addEdge(v, w);
			}
		}
		List<List<Integer>> components = new ArrayList<List<Integer>>(graph.V);
		List<Integer> component = new ArrayList<Integer>();
		ComponentConnectedService connectedService = new ComponentConnectedService(graph, source);
		for(int a=0;a<connectedService.count;a++) {
			components.add(component);
		}
		System.out.println(graph.V);
		int token=0;
		for(int a=0;a<connectedService.count;a++) {
			List<Integer> innerlist = new ArrayList<Integer>();
			for(int i=0;i<graph.V;i++) {
				if(connectedService.id[i]==a) {
					innerlist.add(i);
				}
			}
			components.set(a, innerlist);
		}
		System.out.println("Graph has connected components :"+components.toString());
	}

}
