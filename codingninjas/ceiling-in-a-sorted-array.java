/*
  Problem link: https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401
  Description:
  You're given a sorted array 'a' of 'n' integers and an integer 'x'. Find the floor and ceiling of 'x' in 'a[0..n-1]'.
  Note:
  Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
  Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.
*/

import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      // Wriute your code here.
        int lo = 0;
        int hi = n-1;
        int[] ans = new int[2];
        if(a[0]>x) {
          ans[0] = -1;
          ans[1] = a[0];
        }
        else if(a[n-1]<x) {
          ans[0] = a[n-1];
          ans[1] = -1;
        }
        else {
          while(lo<=hi) {
              int mid = lo + (hi-lo)/2;
              if(a[mid]==x) {
                ans[0] = x;
                ans[1] = x;
                return ans;
              }
              else if(a[mid]<x) lo = mid+1;
              else hi = mid-1; 
          }
          ans[0]=a[hi];
          ans[1]=a[lo];
        }
        return ans;
    }
    
}
