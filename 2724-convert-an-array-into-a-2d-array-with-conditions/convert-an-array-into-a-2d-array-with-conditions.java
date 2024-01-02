class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        for(int i=0;i<nums.length;) {
            if(ans.size()==index) {
                ans.add(new ArrayList<>());
            }
            if(ans.get(index).size()==0 || ans.get(index).get(ans.get(index).size()-1)!=nums[i]) {
                ans.get(index).add(nums[i++]);
            }
            if(i<=nums.length-1 && nums[i]==nums[i-1]) {
                index++;
            }
            else if(i<=nums.length-1 && nums[i]!=nums[i-1]) {
                index=0;
            }
        }
        return ans;
    }
}