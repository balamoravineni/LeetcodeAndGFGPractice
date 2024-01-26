/*
  Problem Link: https://www.codingninjas.com/studio/problems/selection-sort_624469
  Description:
  Sort the given unsorted array 'arr' of size 'N' in non-decreasing order using the selection sort algorithm.
*/

public class Solution {
    public static void selectionSort(int[] arr) {
        //Your code goes here
        int n = arr.length;
        for(int i=0;i<n-1;i++) { // select minimums (or maximums) in each step for non-decreasing order (or non-increasing order)
            int minIndex = i;
            for(int j=i+1;j<n;j++) {
                if(arr[j]<arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex!=i) { // swap
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
