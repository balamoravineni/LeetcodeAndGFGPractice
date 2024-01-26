/*
  Problem link: https://www.codingninjas.com/studio/problems/merge-sort_5846
  Description: 
  You are given the starting 'l' and the ending 'r' positions of the array 'ARR'.
  You must sort the elements between 'l' and 'r'.
*/

public class Solution {

    public static void mergeSort(int[] arr, int l, int r){
        // Write your code here
        if(l==r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid+1;
        int[] temp = new int[end-start+1];
        int k = 0;
        while(i<=mid && j<=end) {
            if(arr[i]<=arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while(i<=mid) temp[k++] = arr[i++];
        while(j<=end) temp[k++] = arr[j++];
        for(k=0;k<end-start+1;k++) {
            arr[start+k] = temp[k];
        }
    }
}
