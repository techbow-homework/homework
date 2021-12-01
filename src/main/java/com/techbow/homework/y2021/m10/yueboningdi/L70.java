import java.util.Arrays;

/*
L70 Climbing Stairs
 */
public class L70 {
    //solution 0: naive recursion
    public static int climbStairs_sol0(int n){
        //corner case
        if (n < 0){
            throw new IllegalArgumentException("Illegal input: negative stair count!");
        }
        //base case
        if (n == 0 || n == 1){
            return 1;
        }
        return climbStairs_sol0(n - 1) + climbStairs_sol0(n - 2);
    }

    //solution 2: dp
    //ans[i] stores the number of distinct ways when the number of staircase is i steps.
    public static int climbStairs_sol1(int n){
        //corner case
        if (n < 0){
            throw new IllegalArgumentException("Illegal input: negative stair count!");
        }
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        int i = 2;
        while (i <= n){
            ans[i] = ans[i - 1] + ans[i - 2];
            i++;
        }
        System.out.println(Arrays.toString(ans));
        return ans[n];
    }

    //dp optimized
    public static int climbStairs_sol1_2(int n){
        //corner case
        if (n < 0){
            throw new IllegalArgumentException("Illegal input: negative stair count!");
        }
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int ansNMinusTwo = 1;
        int ansNMinusOne = 1;
        int ansN = 0;
        int i = 2;
        while (i <= n){
            ansN = ansNMinusOne + ansNMinusTwo;
            if (i == n){
                break;
            }else{
                ansNMinusTwo = ansNMinusOne;
                ansNMinusOne = ansN;
                i++;
            }
        }
        return ansN;
    }

    public static void main(String[] args){
        int n = 8;
        System.out.println(climbStairs_sol0(n));
        climbStairs_sol1(n);
    }
}
