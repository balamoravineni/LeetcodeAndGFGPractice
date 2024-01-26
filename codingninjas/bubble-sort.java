/*
  Problem Link: https://www.codingninjas.com/studio/problems/bubble-sort_624380
  Description: 
  You are given an integer array 'arr' of size 'N'.
  You must sort this array using 'Bubble Sort'.
*/

public class Solution {
    public static void bubbleSort(int[] arr, int n) {
        //Your code goes here
        for(int i=0;i<n-1;i++) {
            // push the max to the last using adjacent swaps
            boolean swap = false; //optimisation if there are no swaps
            for(int j=0;j<n-1-i;j++) {
                if(arr[j+1]<arr[j]) { // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
        }
    }

}
