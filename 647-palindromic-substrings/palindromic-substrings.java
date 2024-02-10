class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                String temp = s.substring(i,j);
                if(isPalindrome(temp)) ans++;
            }  
        }
        return ans;
    }
    
    // Map<String,Boolean> memo = new HashMap<>();

    boolean isPalindrome(String curr) {
        // if(memo.containsKey(curr)) return memo.get(curr);
        int i=0; 
        int j=curr.length()-1;
        while(i<j) {
            if(curr.charAt(i)!=curr.charAt(j)) {
                // memo.put(curr, false);
                return false;
            }
            i++;
            j--;
        }
        // memo.put(curr, true);
        return true;
    }
}