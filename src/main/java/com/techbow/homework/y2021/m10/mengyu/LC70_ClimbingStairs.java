package com.techbow.homework.y2021.m10.mengyu;

public class LC70_ClimbingStairs {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(n, memo);
    }
    public int climb_Stairs(int n, int memo[]) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = climb_Stairs(n - 1, memo) + climb_Stairs(n - 2, memo);
        return memo[n];
    }
}
