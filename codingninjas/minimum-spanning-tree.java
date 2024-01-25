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


class DisjointSet {
    
    List<Integer> parents = new ArrayList<>();
    List<Integer> ranks = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();
    
    DisjointSet(int n) {
        for(int i=0;i<=n;i++) {
            parents.add(i);
            ranks.add(0);
            sizes.add(1);
        }
    }
    
    public int findUParent(int node) {
        if(node==parents.get(node)) return node;
        int parent = parents.get(node);
        int ulParent = findUParent(parent);
        parents.set(node, ulParent);
        return parents.get(node);
    }
    
    public void unionByRank(int node1, int node2) {
        int ul_par1 = findUParent(node1);
        int ul_par2 = findUParent(node2);
        if(ul_par1==ul_par2) return;
        if(ranks.get(ul_par1)>ranks.get(ul_par2)) {
            parents.set(ul_par2, ul_par1);
        }
        else if(ranks.get(ul_par1)<ranks.get(ul_par2)) {
            parents.set(ul_par1, ul_par2);
        }
        else {
            parents.set(ul_par1, ul_par2);
            ranks.set(ul_par2, ranks.get(ul_par2)+1);
        }
    }
    
    public void unionBySize(int node1, int node2) {
        int ul_par1 = findUParent(node1);
        int ul_par2 = findUParent(node2);
        if(ul_par1==ul_par2) return;
        if(sizes.get(ul_par1)>sizes.get(ul_par2)) {
            parents.set(ul_par2, ul_par1);
            sizes.set(ul_par1, sizes.get(ul_par2)+sizes.get(ul_par1));
        }
        else { // covers both less than or equal for sizes
            parents.set(ul_par1, ul_par2);
            sizes.set(ul_par2, sizes.get(ul_par2)+sizes.get(ul_par1));
        }
    }
}


public class Solution {

	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		//Your code goes here
		// return usingPrimsAlgo(edges,n);
		return usingKruskalsAlgo(edges, n);
	}

	static int usingKruskalsAlgo(ArrayList<ArrayList<Integer>> edges, int n) {
		DisjointSet ds = new DisjointSet(n);
		Collections.sort(edges, (e1, e2) -> e1.get(2)-e2.get(2));
		int ans = 0;
		for(ArrayList<Integer> edge: edges) {
			int node1 = edge.get(0);
			int node2 = edge.get(1);
			int weight = edge.get(2);
			if(ds.findUParent(node1)!=ds.findUParent(node2)) {
				ans += weight;
				ds.unionBySize(node1, node2);
			}
		}
		return ans;
	}

	static int usingPrimsAlgo(ArrayList<ArrayList<Integer>> edges, int n) {
		List<List<Pair>> adjList = new ArrayList<>();
		for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
		for(ArrayList<Integer> edge: edges) {
			adjList.get(edge.get(0)).add(new Pair(edge.get(1), edge.get(2)));
			adjList.get(edge.get(1)).add(new Pair(edge.get(0), edge.get(2)));

		}
		return primsalgo(adjList,n);
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
