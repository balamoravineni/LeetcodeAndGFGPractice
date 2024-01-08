class Solution {
    public void setZeroes(int[][] matrix) {
        // bigOMplusN(matrix);
        optimised(matrix);
    }

    void optimised(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // using first row & first columns as reference
        boolean row0 = false, col0 = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0) {
                    if(i==0) row0 = true;
                    if(j==0) col0 = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }   
            }
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0 ) {
                    matrix[i][j] = 0;
                }   
            }
        }
        if(row0) for(int j=0;j<m;j++) matrix[0][j] = 0;
        if(col0) for(int i=0;i<n;i++) matrix[i][0] = 0;
    }

    void bigOMplusN(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0) {
                    rows[i]=true;
                    columns[j]=true;
                }   
            }
        }
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++){
                if(rows[i] || columns[j]) {
                    matrix[i][j]=0;
                }   
            }
        }
    }
}