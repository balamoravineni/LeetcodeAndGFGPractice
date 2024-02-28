class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // if there exists a common prefix between left & right's binary representation
        // then that prefix is common for all the remaining numbers in between also.
        // hence we can assume the rest of the binary digits will result in zero only
        int shift = 0;
        while(left!=right) {
            left = left>>1;
            right = right>>1;
            shift++;
        }
        int ans = left;
        while(shift-->0) {
            ans = ans<<1;
        }
        return ans;
    }
}