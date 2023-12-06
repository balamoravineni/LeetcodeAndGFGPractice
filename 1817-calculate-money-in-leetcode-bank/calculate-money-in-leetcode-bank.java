class Solution {
    public int totalMoney(int n) {
        return totalMoneyHelper(n, 1);
    }

    int totalMoneyHelper(int n, int init) {
        if(n<7) return init*n + (((n-1)*n)/2);
        return init*7+1+2+3+4+5+6 + totalMoneyHelper(n-7, init+1);
    } 
}