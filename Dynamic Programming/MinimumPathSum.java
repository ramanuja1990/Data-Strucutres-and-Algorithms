import java.util.*;
class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        int[][] uniquePathSum = new int[row+1][col+1];
        for(int[] arrayRows : uniquePathSum){
            Arrays.fill(arrayRows, Integer.MAX_VALUE);
        }
       return findMinPath(row, col, uniquePathSum, grid);
        
    }
    
    public int findMinPath(int row, int col, int[][] uniquePathSum, int[][] grid){
       
        if(row < 0 || col < 0)
            return -1;
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(uniquePathSum[row][col] != Integer.MAX_VALUE){
            return uniquePathSum[row][col];
        }
        
        int rowSum = findMinPath(row, col-1, uniquePathSum, grid);
        if(rowSum != -1) {
        	uniquePathSum[row][col] = Math.min((rowSum + grid[row][col]), uniquePathSum[row][col]);
        }
        int colSum =  findMinPath(row-1, col, uniquePathSum, grid);
        if(colSum != -1) {
        	uniquePathSum[row][col] = Math.min((colSum + grid[row][col]), uniquePathSum[row][col]);
        }
        return uniquePathSum[row][col];
    }

    public static void main(String[] args){
        int[][] inputArray = {{1,3,1}, {1,5,1}, {4,2,1}};
        MinimumPathSum minSum = new MinimumPathSum();
        System.out.println(minSum.minPathSum(inputArray));
    }
}