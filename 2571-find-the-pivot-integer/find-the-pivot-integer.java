class Solution {
    public int pivotInteger(int n) {
        // return linearTime(n);
        return optimised(n);
    }

    int optimised(int n) {
        // x(x+1)/2 == n(n+1/2) - ((x-1)(x)/2) => x^2 = n(n+1)/2;
        double ans = Math.sqrt(n*(n+1)/2);
        if(ans-(int)ans==0) return (int)ans;
        return -1;
    }

    int linearTime(int n) {
        int i=1;
        int j=n;
        int iSum = i;
        int jSum = j;
        while(i<=j) {
            // System.out.println(i + " " + j + ": " + iSum + " " + jSum);
            if(iSum==jSum) {
                // System.out.println(i + " " + j);
                if(i==j) return i;
                i++; j--;
                iSum += i;
                jSum += j;
            }
            else if(iSum<jSum) {
                i++;
                iSum +=i;
            }
            else {
                j--;
                jSum += j;
            }
        }
        return -1;
    }
}