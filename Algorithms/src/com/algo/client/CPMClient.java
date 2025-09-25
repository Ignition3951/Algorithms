package com.algo.client;

import java.util.List;
import java.util.Stack;

import com.algo.model.DirectedEdge;
import com.algo.model.EdgeWeightedDigraph;
import com.algo.service.GraphService;
import com.algo.service.LongestPath;
import com.algo.service.TopologicalEdgeWeightedDigraphDFSService;

public class CPMClient {

	public static void main(String[] args) {
		List<List<String>> cpmArray = GraphService.readCPMFile("jobsPC.txt");
		System.out.println(cpmArray.toString());
		int noOfJobs=Integer.parseInt(cpmArray.get(0).get(0));
		System.out.println("Number of jobs are : "+noOfJobs);
		int source=noOfJobs*2;
		int sink=noOfJobs*2+1;
		System.out.println("Source : "+source+" Sink : "+sink);
		int counter=1;
		EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(sink+1);
		for(int i=0;i<noOfJobs;i++) {
			double edgeWeight = Double.parseDouble(cpmArray.get(counter).get(0));
			DirectedEdge sourceToStart=new DirectedEdge(source, i, 0.0);
		    edgeWeightedDigraph.addEdge(sourceToStart);
			DirectedEdge jobEdge=new DirectedEdge(i, i+noOfJobs, edgeWeight);
			edgeWeightedDigraph.addEdge(jobEdge);
			DirectedEdge endToSink=new DirectedEdge(i+noOfJobs, sink, 0.0);
			edgeWeightedDigraph.addEdge(endToSink);
			int noOfConstraints= Integer.parseInt(cpmArray.get(counter).get(1));
			for(int j=0;j<noOfConstraints;j++) {
				int node= Integer.parseInt(cpmArray.get(counter).get(j+2));
				DirectedEdge precedenceEdge=new DirectedEdge(i+noOfJobs, node, 0.0);
				edgeWeightedDigraph.addEdge(precedenceEdge);
			}
			counter++;
		}
//		for(int i=0;i<sink+1;i++) {
//			System.out.println("Graph adjacency matrix : "+edgeWeightedDigraph.edges().get(i));
//		}
		
//		TopologicalEdgeWeightedDigraphDFSService digraphDFSService = new TopologicalEdgeWeightedDigraphDFSService(edgeWeightedDigraph);
//		Stack<Integer> reversePost=digraphDFSService.reversePost();
//		while(!reversePost.isEmpty()) {
//			System.out.println(reversePost.pop());
//		}
		
		LongestPath longestPath = new LongestPath(edgeWeightedDigraph, source);
		System.out.println("Longest path!!!!!!!!!!!!!!");
		for(int i=0;i<edgeWeightedDigraph.vertices();i++) {
			System.out.print("Edge from "+source+" to "+i+" is ");
			System.out.print(longestPath.pathTo(i)+" Weight is : "+longestPath.weight());
			System.out.println();
		}

	}

}
