/*
  Problem Link: https://www.codingninjas.com/studio/problems/distinct-islands_630460
  Description: 
  You are given a two-dimensional array/list of integers consisting of 0s and 1s. In the list, 1 represents land and 0 represents water.
  The task is to find the number of distinct islands where a group of connected 1s(horizontally or vertically) forms an island.
  Note: Two islands are considered to be the same if and only if one island is equal to another(not rotated or reflected) i.e if we can translate one island on another without rotating or reflecting then it would be considered as the same islands. 
*/


import java.util.*;
import javafx.util.Pair;

public class Solution 
{
	static int[] x = {0, 1, 0, -1};
	static int[] y = {1, 0, -1, 0};
	public static int distinctIsland(int [][] arr, int n, int m) 
	{
		//write your code here
		Set<List<String>> ans = new HashSet<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					List<String> current = new ArrayList<>();
					dfs(i,j,arr,n,m, current, i,j);
					ans.add(current);
					// for(int p=0;p<n;p++) {
					// 	for(int q=0;q<m;q++) 
					// 		System.out.print(arr[p][q] + " ");
					// 	System.out.println();
					// }
				}
			}
		}
		return ans.size();
	}

	static String toString(int i, int j) {
		return i + " " + j;
	}

	static void dfs(int i, int j, int [][] arr, int n, int m, List<String> current, int initX, int initY) {
		current.add(toString(i-initX, j-initY));
		arr[i][j] = 0;
		for(int z=0;z<4;z++) {
			int nextI = i + x[z];
			int nextJ = j + y[z];
			if(nextI>=0 && nextI<n && nextJ>=0 && nextJ<m 
				&& arr[nextI][nextJ]==1) { 
					dfs(nextI,nextJ,arr,n,m, current, initX, initY);
			}
		}
	}
}
