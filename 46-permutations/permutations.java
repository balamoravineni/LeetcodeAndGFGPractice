class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursive(nums, 0, ans);
        return ans;
    }

    void recursive(int[] nums, int index, List<List<Integer>> ans) {
        if(index==nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int t: nums) temp.add(t);
            ans.add(temp);
            return;
        }
        for(int i=index;i<nums.length;i++) {
            swap(nums,i,index);
            recursive(nums, index+1, ans);
            swap(nums,i,index);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}