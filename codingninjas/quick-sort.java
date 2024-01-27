/*
  Problem Link: https://www.codingninjas.com/studio/problems/quick-sort_5844
  Description:
  Given the 'start' and the 'end'' positions of the array 'input'. Your task is to sort the elements between 'start' and 'end' using quick sort.
*/

public class Solution {
	
	public static void quickSort(int[] input,int startIndex, int endIndex) {
		if(startIndex>=endIndex) return;
		// System.out.println("pivot index: " + j);
		int pIndex = quickSortHelper(input, startIndex, endIndex);
		quickSort(input, startIndex, pIndex-1);
		quickSort(input, pIndex+1, endIndex);
	}

	static int quickSortHelper(int[] input,int startIndex, int endIndex) {
		int pivot = input[startIndex];
		int i = startIndex+1, j = endIndex;
		while(i<=j) {
			while(i<=endIndex && input[i]<=pivot) i++;
			while(j>=startIndex && input[j]>pivot) j--;
			// System.out.println(i + " " + j);
			if(i<j) swap(input, i, j);
		}
		// j -> pivotIndex / partitionIndex
		swap(input, startIndex, j);
		return j;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
