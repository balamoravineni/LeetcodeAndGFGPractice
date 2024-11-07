class Solution {
    public int largestRectangleArea(int[] heights) {
        // return bruteForce(heights);
        // return twoPassMonotoneStack(heights);
        return onePassMonotoneStack(heights);
    }

    int onePassMonotoneStack(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<=heights.length;i++) {
            while(!stack.isEmpty() && (i==heights.length || heights[stack.peek()]>=heights[i])) {
                int currIndex = stack.pop();
                int height = heights[currIndex];
                int rightSmaller = i;
                int leftSmaller = stack.isEmpty()?-1:stack.peek();
                int width = rightSmaller-leftSmaller-1;
                int area = height*width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }

    int twoPassMonotoneStack(int[] heights) {
        //nextLower
        int[] nextLower = new int[heights.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=heights.length-1;i>=0;i--) {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                nextLower[i] = heights.length;
            }
            else {
                nextLower[i] = stack.peek();
            }
            stack.push(i);
        }
        // for(int temp: nextLower) {
        //     System.out.print(temp+ " ");
        // }
        // System.out.println();

        stack.clear();
        int[] prevLower = new int[heights.length];
        for(int i=0;i<heights.length;i++) {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                prevLower[i] = -1;
            }
            else {
                prevLower[i] = stack.peek();
            }
            stack.push(i);
        }
        // for(int temp: prevLower) {
        //     System.out.print(temp+ " ");
        // }
        // System.out.println();

        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            int height = heights[i];
            int width = nextLower[i] - prevLower[i]-1;
            int area = height*width;
            // System.out.print(area + " ");
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    int bruteForce(int[] heights) {
        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            int prevLower = -1;
            for(int j=i-1;j>=0;j--) {
                if(heights[j]<heights[i]) {
                    prevLower = j;
                    break;
                }       
            }
            int nextLower = heights.length;
            for(int j=i+1;j<heights.length;j++) {
                if(heights[j]<heights[i]) {
                    nextLower = j;
                    break;
                }       
            }
            int currArea = heights[i]*(nextLower-prevLower-1);
            maxArea = Math.max(maxArea,currArea);
        }
        return maxArea;
    }
}