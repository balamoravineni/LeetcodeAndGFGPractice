class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        Set<Integer> givingTrust = new HashSet<>();
        Map<Integer, Set<Integer>> takingTrust = new HashMap<>();
        for(int[] temp: trust) {
            givingTrust.add(temp[0]);
            if(!takingTrust.containsKey(temp[1])) {
                takingTrust.put(temp[1], new HashSet<>());
            }
            takingTrust.get(temp[1]).add(temp[0]);
        }
        for(int i=1;i<=n;i++) {
            if(givingTrust.contains(i)) continue;
            else {
                if(takingTrust.containsKey(i) && takingTrust.get(i).size()==n-1) return i;
            }
        }
        return -1;
    }

    int usingBooleanArray(int n, int[][] trust) {
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