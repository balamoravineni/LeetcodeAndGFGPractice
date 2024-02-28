class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        // calculate primeFactorsMap
        Map<Integer,List<Integer>> primeFactorsMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            getAllPrimeFactors(primeFactorsMap, nums[i], i);
        }
        System.out.println(primeFactorsMap);

        // create edges between the nums having common prime
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<nums.length;i++) adjList.add(new ArrayList<>());
        for(int key: primeFactorsMap.keySet()) {
            List<Integer> list = primeFactorsMap.get(key);
            for(int i=1;i<list.size();i++) {
                int num1 = list.get(i);
                int num2 = list.get(i-1);
                adjList.get(num1).add(num2);
                adjList.get(num2).add(num1);
            }
        }

        // dfs & see if its all one connected component
        int ans = 0;
        boolean[] visited = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(!visited[i]) {
                ans++;
                dfs(adjList, i, visited);
            }
        }
        return ans==1?true:false;
    }

    void dfs(List<List<Integer>> adjList, int index, boolean[] visited) {
        visited[index] = true;
        for(int temp: adjList.get(index)) {
            if(!visited[temp]) dfs(adjList, temp, visited);
        }
    }

    void getAllPrimeFactors(Map<Integer,List<Integer>> map, int n, int index) {
        // even primeFactor
        if(n%2==0) {
            if(!map.containsKey(2)) map.put(2, new ArrayList<>());
            map.get(2).add(index);
        }
        while(n%2==0) n/=2;
        // odd primeFactors
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0) {
                if(!map.containsKey(i)) map.put(i, new ArrayList<>());
                map.get(i).add(index);
            }
            while(n%i==0) n/=i;
        }
        // if the number itself is prime
        if(n>2) {
            if(!map.containsKey(n)) map.put(n, new ArrayList<>());
            map.get(n).add(index);
        }
    }
}