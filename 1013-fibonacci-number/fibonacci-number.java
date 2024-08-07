class Solution {
    public int fib(int n) {
        return recursive(n);
    }

    int recursive(int n) {
        if(n<=1) return n;
        return recursive(n-1) + recursive(n-2);
    }
}