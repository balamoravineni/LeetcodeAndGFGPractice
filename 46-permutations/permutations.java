class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        recursive(nums, new ArrayList<>(), visited, ans);
        return ans;
    }

    void recursive(int[] nums, List<Integer> permutation,boolean[] visited, List<List<Integer>> ans) {
        if(permutation.size()==nums.length) {
            ans.add(new ArrayList(permutation));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(!visited[i]) {
                permutation.add(nums[i]);
                visited[i] = true;
                recursive(nums, permutation, visited, ans);
                permutation.remove(permutation.size()-1);
                visited[i] = false;
            }
        }
    }
}