class Solution {
    Map<String,Integer> dpMap = new HashMap<>();

    public int numDecodings(String s) {
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