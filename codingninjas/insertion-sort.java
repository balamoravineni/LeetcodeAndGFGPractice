/*
  Problem Link: https://www.codingninjas.com/studio/problems/insertion-sort_624381
  Description:
  You are given an integer array 'arr' of size 'N'.
  You must sort this array using 'Insertion Sort' recursively.
*/

public class Solution {
    public static void insertionSort(int[] arr, int size) {
        //Your code goes here
        // Insert each element in its correct position
        for(int i=1;i<size;i++) {
            for(int j=i-1;j>=0;j--) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }
}
