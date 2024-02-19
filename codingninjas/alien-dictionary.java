/*
  Problem Link: https://www.codingninjas.com/studio/problems/alien-dictionary_630423
  Description:
  You have been given a sorted (lexical order) dictionary of an alien language.
  Write a function that returns the order of characters as a string in the alien language. 
  This dictionary will be given to you as an array of strings called 'dictionary', of size 'N', with 'K' letters.
  Note:
  If the language consists of four letters, the four letters should be the starting four letters of the English language. 
*/

import java.util.*;

public class Solution {
    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        int[][] adjArr = new int[k][k];
        for(int i=0;i<dictionary.length-1;i++) {
            String first = dictionary[i];
            String second = dictionary[i+1];
            for(int j=0;j<first.length() && j<second.length();j++) {
                if(first.charAt(j)!=second.charAt(j)) {
                    adjArr[first.charAt(j)-'a'][second.charAt(j)-'a'] = 1;
                    break;
                }
                else continue;
            }
        }
        List<Integer> stack = new ArrayList<>();
        int[] visited = new int[k];
        for(int i=0;i<k;i++) {
            if(visited[i]==0 && dfsIsCyclic(adjArr, i, visited, stack)) {
                System.out.println("Cycle detected");
            }
        }
        Collections.reverse(stack);
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<stack.size();i++) ans.append((char)('a'+stack.get(i)));
        // System.out.println(ans);
        return ans.toString();
    }
    static boolean dfsIsCyclic(int[][] adjArr, int index, int[] visited, List<Integer> stack) {
        visited[index] = 2;
        for(int i=0;i<adjArr.length;i++) {
            if(adjArr[index][i]==1 && visited[i]==2) return true;
            if(adjArr[index][i]==1 && visited[i]==0 && dfsIsCyclic(adjArr, i, visited, stack)) {
                return true;
            }
        }
        visited[index] = 1;
        stack.add(index);
        return false;
    }
}
