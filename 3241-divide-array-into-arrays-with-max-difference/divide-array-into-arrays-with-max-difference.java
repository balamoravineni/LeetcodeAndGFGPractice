class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = n/3;
        int[][] ans = new int[l][3];
        boolean possible = true;
        int z = 0;
        for(int i=0;i<n-2;i+=3) {
            int a = nums[i];
            int b = nums[i+1];
            int c = nums[i+2];
            if(Math.abs(a-b)<=k && Math.abs(b-c)<=k && Math.abs(c-a)<=k) {
                ans[z][0] = a;
                ans[z][1] = b;
                ans[z][2] = c;
                z++;
            }
            else {
                possible = false;
                break;
            }
        }
        if(!possible) return new int[0][0];
        return ans;
    }
}