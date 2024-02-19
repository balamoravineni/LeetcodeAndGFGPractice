class Solution {
    public boolean isPowerOfTwo(int n) {
        // return recursive(n);
        return usingBitManipulation(n);
    }

    boolean usingBitManipulation(int n) {
        if(n<=0) return false;
        return (n&(n-1))==0;
    }

    boolean recursive(int n) {
        if(n==0) return false;
        if(n==1) return true;
        return n%2==0 && recursive(n/2);
    }
}