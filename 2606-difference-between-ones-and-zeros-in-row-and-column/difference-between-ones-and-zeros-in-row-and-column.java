class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[] onesInRows = new int[rows];
        int[] onesInColumns = new int[columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                if(grid[i][j]==1) {
                    onesInRows[i]++;
                    onesInColumns[j]++;
                }
            }
        }
        int[][] diff = new int[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                diff[i][j] = onesInRows[i] + onesInColumns[j] - (columns-onesInRows[i]) - (rows-onesInColumns[j]);
            }
        }
        return diff;
    }
}