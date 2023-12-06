class Solution {
    public int totalMoney(int n) {
        // return totalMoneyHelper(n, 1);
        int x = n/7;
        int ans = 0;
        if(x>0) ans = 7*(x*(x+1)/2) + x*(1+2+3+4+5+6);
        // System.out.println(ans);
        int y = n%7;
        if(y>0) ans += ((x+1)*y + (((y-1)*y)/2));
        return ans;
    }

    int totalMoneyHelper(int n, int init) {
        if(n<7) return init*n + (((n-1)*n)/2);
        return init*7+1+2+3+4+5+6 + totalMoneyHelper(n-7, init+1);
    } 
}