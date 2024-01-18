/*
  Implementing Disjoint Set by Union Rank/ Union Size & Path Compression
  only Union / findUParent may take O(log N) time, but because of path compression it takes constant time
  Time complexity: O(4*alpha) ~ O(constant) since alpha is near about 1. derivation is out of scope 
*/

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


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
        else if(sizes.get(ul_par1)<sizes.get(ul_par2)) {
            parents.set(ul_par1, ul_par2);
            sizes.set(ul_par2, sizes.get(ul_par2)+sizes.get(ul_par1));
        }
        else { // sizes are equals
            parents.set(ul_par1, ul_par2);
            sizes.set(ul_par2, sizes.get(ul_par2)*2);
        }
    }
}

class MainApplication {
	
	public static void main (String[] args) {
        
        System.out.println("Disjoint Set implementation: ");
        DisjointSet ds = new DisjointSet(7);
        
        ds.unionByRank(1, 2); 
        ds.unionByRank(2, 3); 
        ds.unionByRank(4, 5); 
        ds.unionByRank(6, 7); 
        ds.unionByRank(5, 6); 
        
        // if 3 and 7 same or not 
        if(ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same"); 
        }
        else 
            System.out.println("Not Same"); 
            
        ds.unionByRank(3, 7); 
        if(ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same"); 
        }
        else 
            System.out.println("Not Same"); 
            
        System.out.println();
        
        DisjointSet ds2 = new DisjointSet(7);
        
        ds2.unionBySize(1, 2); 
        ds2.unionBySize(2, 3); 
        ds2.unionBySize(4, 5); 
        ds2.unionBySize(6, 7); 
        ds2.unionBySize(5, 6); 
        
        // if 3 and 7 same or not 
        if(ds2.findUParent(3) == ds2.findUParent(7)) {
            System.out.println("Same"); 
        }
        else 
            System.out.println("Not Same"); 
            
        ds2.unionBySize(3, 7); 
        if(ds2.findUParent(3) == ds2.findUParent(7)) {
            System.out.println("Same"); 
        }
        else 
            System.out.println("Not Same"); 
            
        System.out.println();
        
	}

}
