class Solution {
    public int numSpecial(int[][] mat) {
        // return bruteForce(mat);
        int rows = mat.length;
        int columns = mat[0].length;
        int[] onesInRow = new int[rows];
        int[] onesInColumn = new int[columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                if(mat[i][j]==1) {
                    onesInRow[i]++;
                    onesInColumn[j]++;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                if(mat[i][j]==1) {
                    if(onesInRow[i]==1 && onesInColumn[j]==1) ans++;
                }
            }
        }
        return ans;
    }

    int bruteForce(int[][] mat) {
        int ans=0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1 && checkIfSpecial(mat,i,j)) ans++;
            }
        }
        return ans;
    }

    boolean checkIfSpecial(int[][] mat, int row, int col) {
        for(int j=0;j<mat[0].length;j++) {
            if(j!=col && mat[row][j]==1) return false;
        }
        for(int i=0;i<mat.length;i++) {
            if(i!=row && mat[i][col]==1) return false;
        }
        return true;
    }
}