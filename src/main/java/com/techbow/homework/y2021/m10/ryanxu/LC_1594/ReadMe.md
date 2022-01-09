### 解题思路：
在matrix上求最大乘积，并且只能向右和下移动，容易想到dp解法，特殊点在于本题元素有正有负，要计算
乘积思路跟[152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
一样，dp[i] 由 dp[i][j - 1] 和 dp[i - 1][j]确定，由于需要考虑正负，需要记录这两个状态的最大和
最小值，即：
>  dp1[i][j] = Math.max(Math.max(dp1[i - 1][j] * grid[i][j], dp2[i - 1][j] * grid[i][j]),
Math.max(dp1[i][j - 1] * grid[i][j], dp2[i][j - 1] * grid[i][j]));  
> dp2[i][j] = Math.min(Math.min(dp1[i - 1][j] * grid[i][j], dp2[i - 1][j] * grid[i][j]),
Math.min(dp1[i][j - 1] * grid[i][j], dp2[i][j - 1] * grid[i][j]));