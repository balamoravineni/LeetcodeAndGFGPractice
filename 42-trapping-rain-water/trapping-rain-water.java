class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while(l<=r) {
            if(height[l]<=height[r]) {
                if(height[l]>=leftMax) leftMax = height[l];
                else ans += leftMax-height[l];
                l++;
            }
            else { // height[r]<height[l]
                if(height[r]>=rightMax) rightMax = height[r];
                else ans += rightMax-height[r];
                r--;
            }
        }
        return ans;
    }
}