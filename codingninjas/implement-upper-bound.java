/*
  Problem link: https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383
  Description:
  You are given a sorted array ‘arr’ containing ‘n’ integers and an integer ‘x’.
  Implement the ‘upperBound’ function to find the index of the upper bound of 'x' in the array.
  Note:
  The upper bound in a sorted array is the index of the first value that is greater than a given value. 
  If the greater value does not exist then the answer is 'n', Where 'n' is the size of the array.
  We are using 0-based indexing.
  Try to write a solution that runs in log(n) time complexity.
*/

public class Solution {
    public static int upperBound(int []arr, int x, int n){
        // Write your code here.
        int lo = 0, hi = n-1;
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid]<=x) lo = mid+1;
            else hi = mid-1;
        }
        return lo;
    }
}
