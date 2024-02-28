class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] people = new boolean[n];
        for(int[] temp: trust) people[temp[0]-1] = true;
        int ans = -1;
        for(int i=0;i<n;i++) if(people[i]==false) ans = i;
        if(ans==-1) return -1;
        people = new boolean[n];
        for(int[] temp: trust) {
            if(temp[1]-1==ans) people[temp[0]-1] = true;
        }
        boolean allTrust = true;
        for(int i=0;i<n;i++) {
            if(i!=ans && people[i]==false) allTrust=false;
        }
        if(!allTrust) return -1;
        return ans+1;
    }
}