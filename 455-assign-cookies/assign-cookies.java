class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length-1;
        int i = g.length-1;
        int ans = 0;
        while(j>=0 && i>=0) {
            while(i>=0 && g[i]>s[j]) i--;
            if(i>=0 && j>=0) ans++;
            i--;j--;
        }
        return ans;
    }
}