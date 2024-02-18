class Solution {
    public int largestRectangleArea(int[] heights) {
        // return bruteForce(heights);
        // return usingMonotoneStack(heights);
        return optimised(heights);
    }

    int optimised(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                int currentIndex = stack.pop();
                int l = heights[currentIndex];
                int rightSmaller = i;
                int rightB = rightSmaller-currentIndex-1;
                int leftSmaller = -1;
                if(!stack.isEmpty()) leftSmaller = stack.peek();
                int leftB = currentIndex-leftSmaller-1;
                int b = 1 + rightB + leftB;
                ans = Math.max(ans, l*b);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int currentIndex = stack.pop();
            int l = heights[currentIndex];
            int rightSmaller = n;
            int rightB = rightSmaller-currentIndex-1;
            int leftSmaller = -1;
            if(!stack.isEmpty()) leftSmaller = stack.peek();
            int leftB = currentIndex-leftSmaller-1;
            int b = 1 + rightB + leftB;
            ans = Math.max(ans, l*b);
        }
        return ans;
    }

    int usingMonotoneStack(int[] heights) { // TC: O(2*N); SC: O(2*N)
        int n = heights.length;
        int[] leftSmaller = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=n-1;i>=0;i--) {
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                leftSmaller[stack.pop()] = i;  
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) leftSmaller[stack.pop()] = -1;

        // stack.clear();
        int ans = 0;
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]) {
                int currentIndex = stack.pop();
                int l = heights[currentIndex];
                int rightSmaller = i;
                int rightB = rightSmaller-currentIndex-1;
                int leftB = currentIndex-leftSmaller[currentIndex]-1;
                int b = 1 + rightB + leftB;
                ans = Math.max(ans, l*b);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int currentIndex = stack.pop();
            int l = heights[currentIndex];
            int rightSmaller = n;
            int rightB = rightSmaller-currentIndex-1;
            int leftB = currentIndex-leftSmaller[currentIndex]-1;
            int b = 1 + rightB + leftB;
            ans = Math.max(ans, l*b);
        }
        return ans;
    }

    int bruteForce(int[] heights) { // TC: O(N^2); SC: O(1)
        int ans = 0;
        int n = heights.length;
        for(int i=0;i<n;i++) {
            int l = heights[i];
            int b = 1;
            for(int j=i-1;j>=0;j--) {
                if(heights[j]>=l) b++;
                else break;
            }
            for(int j=i+1;j<n;j++) {
                if(heights[j]>=l) b++;
                else break;
            }
            ans = Math.max(ans, l*b);
        }
        return ans;
    }
}