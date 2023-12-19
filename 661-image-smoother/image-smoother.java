class Solution {

    int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public int[][] imageSmoother(int[][] img) {
        int rows = img.length, columns = img[0].length;
        int[][] ans = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                int sum = 0, num = 0;
                for(int p=0;p<9;p++) {
                    if(i+dx[p]>=0 && i+dx[p]<rows && j+dy[p]>=0 && j+dy[p]<columns) {
                        num++;
                        sum += img[i+dx[p]][j+dy[p]];
                    }
                }
                ans[i][j] = sum/num;
            }
        }
        return ans;
    }
}