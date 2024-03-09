/*
  Problem Link: https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
  Description:
  Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
  Note: Unlike 0/1 knapsack, you are allowed to break the item here. 
*/

/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, (i1, i2) -> {
            double res = ((double)i2.value/i2.weight) - ((double)i1.value/i1.weight);
            if(res==0.0) return 0;
            if(res<0) return -1;
            return 1;
        });
        double ans = 0;
        for(Item temp: arr) {
            if(W==0) break;
            if(temp.weight<=W) {
                ans += temp.value;
                W -= temp.weight;
            }
            else {
                ans += ((double)temp.value/temp.weight)*W;
                W=0;
            }
        }
        return ans;
    }
}
