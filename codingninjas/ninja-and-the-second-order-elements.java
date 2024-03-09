/*
  Problem Link: https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960
  Description:
  You have been given an array ‘a’ of ‘n’ unique non-negative integers.
  Find the second largest and second smallest element from the array.
  Return the two elements (second largest and second smallest) as another array of size 2.
*/

// import java.util.Arrays;
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int[] ans = new int[2];
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int temp = a[i];
            if(temp>max) {
                ans[0] = max;
                max = temp;
            }
            else if(temp>ans[0]) {
                ans[0] = temp;
            }
            if(temp<min) {
                ans[1] = min;
                min = temp;
            }
            else if(temp<ans[1]) {
                ans[1] = temp;
            }
        }
        return ans;
        // Arrays.sort(a);
        // ans[0] = a[n-2];
        // ans[1] = a[1];
        // return ans;
    }
}
