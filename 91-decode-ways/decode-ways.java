class Solution {

    public int numDecodings(String s) {
        // return amateurCode(s);
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return recursiveHelper(s,0,dp);
    }

    int recursiveHelper(String s, int index, int[] dp) {
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index]!=-1) return dp[index];
        int ans = recursiveHelper(s, index+1, dp);
        if(index+2<=s.length() && Integer.parseInt(s.substring(index, index+2))<=26) {
            ans += recursiveHelper(s, index+2, dp);
        }
        return dp[index]=ans;
    }


    Map<String,Integer> dpMap = new HashMap<>();
    int amateurCode(String s) {
        if(s.charAt(0)=='0') return 0;
        else if(s.length()==1) return 1;
        else if(s.length()==2 && (s.charAt(1)=='0' && s.charAt(0)>'2')) return 0;
        else if(s.length()==2 && (s.charAt(1)=='0' && s.charAt(0)<='2')) return 1;
        else if(s.length()==2 && (s.charAt(0)>='3' || (s.charAt(0)=='2' && s.charAt(1)>='7'))) return 1;
        else if(s.length()==2) return 2;
        int ans = 0;
        if(isValidChar(s.substring(0,1))) {
            String next = s.substring(1,s.length());
            if(dpMap.get(next)==null) dpMap.put(next, numDecodings(next));
            ans += dpMap.get(next);
        }
        if(isValidChar(s.substring(0,2))) {
            String next = s.substring(2,s.length());
            if(dpMap.get(next)==null) dpMap.put(next, numDecodings(next));
            ans += dpMap.get(next);
        }
        return ans;
    }

    boolean isValidChar(String s) {
        if(s.charAt(0)=='0') return false;
        else if(s.length()==1) return true;
        else if(s.length()==2 && (s.charAt(0)>='3'||(s.charAt(0)=='2' && s.charAt(1)>='7'))) return false;
        return true;
    }
}