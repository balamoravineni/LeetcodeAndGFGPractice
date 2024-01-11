/*
  Problem link: https://www.codingninjas.com/studio/problems/lower-bound_8165382
  Description: 
  You are given an array 'arr' sorted in non-decreasing order and a number 'x'.
  You must return the index of lower bound of 'x'.
  Note: 
  For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as the smallest index 'idx' such that the value 'arr[idx]' is not less than 'x'
  If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of 'x', where 'n' is the size of array.
  Consider 0-based indexing.
*/

public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int lo = 0, hi = n-1;
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid]<x) lo = mid+1;
            else hi = mid-1;
        }
        return lo;
    }
}
