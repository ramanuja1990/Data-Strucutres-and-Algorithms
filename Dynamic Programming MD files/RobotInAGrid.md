## Robot In a Grid - Leet Code (page 344)

### Solution: Check r-1, c and r, c-1 recursiverly.     dp(row, col) = dp(row-1, col) + dp(row, col-1));


### <strong>Time Complexity: O(2<sup>(r+c)</sup>)</strong>

```
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
```