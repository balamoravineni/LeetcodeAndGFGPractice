class Solution {
    public int countSubstrings(String s) {
        // return bruteForce(s);
        return optimised(s);
    }

    int optimised(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            // single character is always palindrom
            ans += 1;
            // odd length palindromes possible with current index
            ans += countPalindromes(s,i-1,i+1);
            // even length palindromes possible with current index
            ans += countPalindromes(s,i,i+1);
        }
        return ans;
    }

    int countPalindromes(String s, int left, int right) {
        int count = 0;
        while(left>=0 && right<=s.length()-1) {
            if(s.charAt(left)==s.charAt(right)) count++;
            else break;
            left--;
            right++;
        }
        return count;
    }

    int bruteForce(String s) {
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

    boolean isPalindrome(String curr) {
        int i=0; 
        int j=curr.length()-1;
        while(i<j) {
            if(curr.charAt(i)!=curr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}