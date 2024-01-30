class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // boolean[] visited = new boolean[nums.length];
        // recursive(nums, new ArrayList<>(), visited, ans);
        recursiveOptimised(nums, 0, ans);
        return ans;
    }

    void recursiveOptimised(int[] nums, int index, List<List<Integer>> ans) {
        if(index==nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int t: nums) temp.add(t);
            ans.add(temp);
            return;
        }
        for(int i=index;i<nums.length;i++) {
            swap(nums,i,index);
            recursiveOptimised(nums, index+1, ans);
            swap(nums,i,index);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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