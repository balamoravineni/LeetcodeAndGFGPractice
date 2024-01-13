class Solution {
    public int minSteps(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for(int i=0;i<s.length();i++) {
            sCount[s.charAt(i)-'a']++;
            tCount[t.charAt(i)-'a']++;
        }
        int ans = 0;
        for(int i=0;i<26;i++) {
            if(sCount[i]==tCount[i]) continue;
            if(sCount[i]>tCount[i]) {
                int req = sCount[i]-tCount[i];
                for(int j=0;j<26;j++) {
                    if(i!=j) {
                        if(tCount[j]>sCount[j]) {
                            int diff = (tCount[j]-sCount[j]);
                            if(diff<=req) {
                                tCount[j] -= diff;
                                req -= diff;
                                ans += diff;
                            }
                            else {
                                ans += req;
                                req = 0;
                                tCount[j] -= req;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}