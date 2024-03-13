class Solution {
    public int pivotInteger(int n) {
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