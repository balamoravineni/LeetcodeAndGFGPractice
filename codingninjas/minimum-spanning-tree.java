/*
  Problem Link: https://www.codingninjas.com/studio/problems/minimum-spanning-tree_631769
  Description:
  You are given an undirected, connected and weighted graph G(V, E), consisting of V number of vertices (numbered from 0 to V-1) and E number of edges.
  Find and print the total weight of the Minimum Spanning Tree (MST) using Kruskal's algorithm.
  By definition, a minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
*/

import java.util.*;

class Pair {
	int node, weight;
	Pair(int a, int b) {
		node = a;
		weight = b;
	}
}

class Tuple {
	int node, weight, parent;
	Tuple(int a, int b, int c) {
		node = a;
		weight = b;
		parent = c;
	}
}
public class Solution {

	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//Your code goes here
		List<List<Pair>> adjList = new ArrayList<>();
		for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
		for(ArrayList<Integer> edge: edges) {
			adjList.get(edge.get(0)).add(new Pair(edge.get(1), edge.get(2)));
			adjList.get(edge.get(1)).add(new Pair(edge.get(0), edge.get(2)));

		}
		return primsalgo(adjList,n)
	}
	static int primsalgo(List<List<Pair>> adjList, int n) {
		boolean[] visited = new boolean[n];
		PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> t1.weight-t2.weight);
		pq.add(new Tuple(0,0,-1));
		int mstWeight = 0;
		List<List<Integer>> mstEdges = new ArrayList<>();
		while(!pq.isEmpty()) {
			Tuple curr = pq.remove();
			if(visited[curr.node]) continue;
			visited[curr.node] = true;
			mstWeight += curr.weight;
			if(curr.parent!=-1) mstEdges.add(Arrays.asList(curr.node, curr.parent));
			for(Pair next: adjList.get(curr.node)) {
				if(!visited[next.node]) pq.add(new Tuple(next.node, next.weight, curr.node));
			}
		}
		// System.out.println(mstEdges);
		return mstWeight;
	}
}
