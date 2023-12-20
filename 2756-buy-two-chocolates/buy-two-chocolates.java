class Solution {
    public int buyChoco(int[] prices, int money) {
        int minChoc = Integer.MAX_VALUE;
        int secondMinChoc = Integer.MAX_VALUE;
        for(int price: prices) {
            if(price<minChoc) {
                secondMinChoc = minChoc;
                minChoc = price;
            }
            else {
                secondMinChoc = Math.min(secondMinChoc, price);
            }
        }
        if(money>=minChoc+secondMinChoc) return money - (minChoc+secondMinChoc);
        return money;
    }
}