import java.util.Arrays;

public class RobotInAGrid{

   static int[][] uniquePathsArray;
    public static int uniquePaths(int row, int col){
        if(row < 1 || col < 1)
            return 0;
        if(row == 1 && col == 1)
            return 1;

        if(uniquePathsArray == null){
            uniquePathsArray = new int[row+1][col+1];
            for(int[] arr : uniquePathsArray)
                Arrays.fill(arr, -1);
        }

        if(uniquePathsArray[row][col] != -1){
            return uniquePathsArray[row][col];
        }

        else{
            uniquePathsArray[row][col] = uniquePaths(row-1, col) + uniquePaths(row, col - 1);
        }

        return uniquePathsArray[row][col];
    }
    
    public static void main(String[] args){
        System.out.println(uniquePaths(7, 3));
    }
}