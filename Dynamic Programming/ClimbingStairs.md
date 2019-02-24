# Climbing Stairs
### You are climbing a stair case. It takes n steps to reach to the top.Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

### Solution: Dynamic Programming - Recursion <br/>
### We can get to nth step by <br/>
### (n-1) steps + 1 step  OR (n-2) + 2 steps <br/>

## <strong>Time Complexity: </strong> O(2<sup>n</sup>)

```
import java.util.*;
class ClimbStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(memo, n);
    }
    
    public int countWays(int[] memo, int steps){
        if(steps < 0) 
            return 0;
        else if(steps == 0) 
            return 1;
        else if(memo[steps] > -1)
            return memo[steps];
        else{
            memo[steps] = countWays(memo, steps-1) + countWays(memo, steps-2);
            return memo[steps];
        }
    }

    public static void main(String[] args){
        ClimbStairs stairs = new ClimbStairs();
        System.out.println(stairs.climbStairs(3));
    }
}
```