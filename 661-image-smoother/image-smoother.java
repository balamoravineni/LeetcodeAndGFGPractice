class Solution {


    public int[][] imageSmoother(int[][] img) {
        // return solution(img);
        return spaceOptimizedSoln(img);
    }

    int[][] spaceOptimizedSoln(int[][] img) {
        int rows = img.length, columns = img[0].length;
        int[] temp = new int[columns];
        int[] current = new int[columns];
        int prevNeighbor = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) current[j] = img[i][j];
            for(int j=0;j<columns;j++) {
                int sum = 0, num = 0;
                // bottom neighbors
                if(i+1<rows) {
                    if(j-1>=0) {
                        sum += img[i+1][j-1];
                        num++;
                    }
                    sum += img[i+1][j];
                    num++;
                    if(j+1<columns) {
                        sum += img[i+1][j+1];
                        num++;
                    }
                }
                // next neighbor
                if(j+1<columns) {
                    sum += img[i][j+1];
                    num++;
                }
                //current cell
                sum += img[i][j];
                num++;
                // prevNeighbor
                if(j-1>=0) {
                    sum += prevNeighbor;
                    num++;
                }
                // top neighbors
                if(i-1>=0) {
                    if(j-1>=0) {
                        sum += temp[j-1];
                        num++;
                    }
                    sum += temp[j];
                    num++;
                    if(j+1<columns) {
                        sum += temp[j+1];
                        num++;
                    }
                }
                prevNeighbor = img[i][j];
                img[i][j] = sum/num;
            }
            for(int j=0;j<columns;j++) temp[j] = current[j];
        }
        return img;
    }

    int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    int[][] solution(int[][] img) {
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