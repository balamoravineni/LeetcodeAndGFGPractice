class Solution {
    public boolean check(int[] nums) {
        // return usingTwoArraysLinear(nums);
        return spaceOptimisedLinear(nums);
    }

    boolean spaceOptimisedLinear(int[] nums) {
        if(nums.length<=2) {
            return true;
        }
        Integer list1Lower = null; Integer list1Upper = null;
        Integer list2Lower = null; Integer list2Upper = null;

        list1Lower = nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]>=nums[i-1]) {
                if(list2Lower==null) list1Upper = nums[i];
                else list2Upper = nums[i];
            }
            else {
                if(list2Lower==null) {
                    list2Lower = nums[i];
                }
                else {
                    return false;
                }
            }
        }
        // System.out.println(list1Lower + " " + list1Upper);
        // System.out.println(list2Lower + " " + list2Upper);
        list2Upper = list2Upper!=null?list2Upper:list2Lower;
        if(list2Lower==null || list2Upper<=list1Lower) return true;
        return false;
    }

    boolean usingTwoArraysLinear(int[] nums) {
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