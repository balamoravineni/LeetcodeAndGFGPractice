/*
  Problem link: https://www.codingninjas.com/studio/problems/partitions-with-given-difference_3751628
  Description:
  Given an array ‘ARR’, partition it into two subsets (possibly empty) such that their union is the original array. 
  Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.
  Given a difference ‘D’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’ and the difference between ‘S1’ and ‘S2’ is equal to ‘D’. 
  Since the answer may be too large, return it modulo ‘10^9 + 7’. 
  If ‘Pi_Sj’ denotes the Subset ‘j’ for Partition ‘i’. Then, two partitions P1 and P2 are considered different if:
  1) P1_S1 != P2_S1 i.e, at least one of the elements of P1_S1 is different from P2_S2.
  2) P1_S1 == P2_S2, but the indices set represented by P1_S1 is not equal to the indices set of P2_S2. Here, the indices set of P1_S1 is formed by taking the indices of the elements from which the subset is formed.
  Refer to the example below for clarification.
  Note that the sum of the elements of an empty subset is 0.
*/

import java.util.* ;
import java.io.*; 
public class Solution {


	static int M = (int)1e9 + 7;

	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int total = 0;
		for(int temp: arr) total += temp;
		Integer[][] dp = new Integer[n][total+1];
		return recursive(arr, n,total,d,0,0,dp);

        // Map<String,Integer> dp = new HashMap<>();
        // return recursiveAlternate(arr,d,0,dp);
	}

	static int recursive(int[] arr, int n, int total, int d, int i, int sum, Integer[][] dp) {
		if(i==n) {
			if(sum>=(total-sum) && ((2*sum)-total==d)) return 1;
			return 0;
		}
		if(dp[i][sum]!=null) return dp[i][sum];
		int consider = recursive(arr, n,total,d,i+1, sum+arr[i], dp)%M;
		int notConsider = recursive(arr, n,total,d,i+1, sum, dp)%M;
		return dp[i][sum] = (consider + notConsider)%M;
	}

	static int recursiveAlternate(int[] nums, int target, int i,Map<String,Integer> dp) {
        if(i==nums.length) {
            if(target==0) return 1;
            return 0;
        }
        String str = i + "$" + target;
        if(dp.containsKey(str)) return dp.get(str);
        int plus = recursiveAlternate(nums, target-nums[i], i+1, dp)%M;
        int minus = recursiveAlternate(nums, target+nums[i], i+1, dp)%M;
        dp.put(str, (plus+minus)%M);
        return (plus+minus)%M;
    }
}
