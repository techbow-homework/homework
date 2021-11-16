###解题思路：
每次buy时，手中不能有股票，buy[i][j]表示第i天时已经完成j次交易；每次sell时，手中必须有1支股票
，sell[i][j]同理。这里在 买入 股票时计算交易次数。  
如果 k >= prices.length / 2，题目将转化为不限制交易次数，求maxProfit，同
[122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
如果 k < prices.length / 2，转移方成如下
> buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i])  
> sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i])