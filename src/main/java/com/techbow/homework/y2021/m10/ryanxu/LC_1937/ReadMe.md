### 解题思路：
本题典型的dp思路：dp[i][j]以[i,j]为最后选定元素所能得到的最大points。
> dp[i][j] = max(dp[i - 1][k] + points[i][j] - abs(j - k))

由状态转移方程可知，需要三层for loop时间复杂度为O(mnn)，再看m和n的数量级为10^5。所以直接操作一定会TLE。
再观察转移方程，abs部分并不常见，我们可以化简一下转移方程。
> dp[i][j] = max(dp[i - 1][k] + points[i][j] - j + k) for k <= j; k = 0, 1, 2, ..., j  
> dp[i][j] = max(dp[i - 1][k] + points[i][j] + j - k) for k > j k = j + 1, ..., col - 1  

如果选定j的情况下，k<=j时，points[i][j]-j就相当于常量，并且如果k是从0开始，那么相当于我们是求dp[i-1][k]+k的rollingMax，
这样平均下来的每一列处理的时间复杂度为O(1)。  
同理k>j时，我们只需要填写第二个状态转移方程即可。  

特别注意：将绝对值拆开，用rollingMax来求最大值时，不同转移方程遍历的顺序是关键。