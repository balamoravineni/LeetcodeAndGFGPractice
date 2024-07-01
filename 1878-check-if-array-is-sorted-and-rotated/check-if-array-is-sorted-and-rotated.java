class Solution {
    public boolean check(int[] nums) {
        if(nums.length<=2) {
            return true;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list = list1;
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++) {
            if(nums[i]>=nums[i-1]) {
                list.add(nums[i]);
            }
            else {
                if(list2.size()==0) {
                    list = list2;
                    list.add(nums[i]);
                }
                else {
                    return false;
                }
            }
        }
        if(list2.size()==0 || list2.get(list2.size()-1)<=list1.get(0)) return true;
        return false;
    }
}