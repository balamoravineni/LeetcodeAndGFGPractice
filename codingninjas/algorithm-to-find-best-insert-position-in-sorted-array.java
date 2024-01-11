/*
  Problem link: https://www.codingninjas.com/studio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813
  Description:
  You are given a sorted array 'arr' of distinct values and a target value 'm'.
  You need to search for the index of the target value in the array.
  Note:
  If the value is present in the array, return its index.
  If the value is absent, determine the index where it would be inserted in the array while maintaining the sorted order. 
*/

public class Solution {
    public static int searchInsert(int [] arr, int m){
        // Write your code here.
        int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==m) return mid;
            else if(arr[mid]<m) lo = mid+1;
            else hi = mid-1; 
        }
        return lo;
    }
}
