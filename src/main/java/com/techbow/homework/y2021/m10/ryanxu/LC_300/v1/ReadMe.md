### 解题思路：
dp[i]: [0, i]the length of the longest strictly increasing subsequence end with i;
我们只需要在i之前找到，一个j使得 nums[j] < nums[i]并且在[0, i - 1]中 dp[j]的值最大。