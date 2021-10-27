package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= n <= 19
 */

public class LC_0096 {
    // S1: dp
    /* for a sorted sequence [1, ..., n], to construct unique BST, we could enumerate each number i
    from sequence as root, and use left side subsequence[1, i-1] to construct left subtree, right side
    subsequence[i+1, n] as right subtree, this is based on BST definition. then we can construct subtree
    from subsequence recursively, in this way, all BST should be unique since they start from unique
    root. but during recursion, we might need to solve same size problems more than once, to optimize it,
    we store the solution of subproblems and reuse them later.
    */
    // time: O(n^2)
    // space: O(n) for storing n+1 size dp[]
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) { // compute unique BST for sequence of length n
            for (int j = 1; j <= i; j++) { // compute unique BST with j as root
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    // S2: math deduction -- catalan number Cn
}
