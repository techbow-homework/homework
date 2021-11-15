###解题思路：
如果k 可以取 10^9，如果用常规遍历将会TLE。设函数f(x)表示固定交易x次，交易费用为0，所能得到的最大利润。  
函数图像大致如下图：  
>![f(x)函数图像](https://github.com/Ryannx/git-photo/blob/main/IMG_0023.jpeg?raw=true)  

如果不限制交易的次数并且交易费用a = 0，那么f(x)的函数图像大致如图中黑色曲线，假设交易(Xm)次获得最大利润，
那么交易至多交易次数k，大于或者小于(Xm)，最终获利都将小于最大利润。随着交易费用的增加，整个函数曲线将会向下
便宜，并且(Xm)点将会向左偏移，向左偏移的原因为：如果交易费用为 y，那么交易获利小于y的交易都不会发生，所以
交易的次数会减少，(Xm)点也会向左偏移。  
设函数g(x)为固定交易x次，交易费用为a，所能得到的最大利润(注意！这里求出的x为 所有可能答案的最小值！例如：
k=2   int[] prices = [3,3,5,0,0,3,1,4]，这里Xm = 2, g(x)求出的x=1，a=2，g(x)在相同获利时取较小
的交易次数)。

>g(x) = f(x) - ax

假设交易 K（大写） 次，交易费用为a，将最大获利
>g(K) = f(K) - aK

题目中给出的 k 点可能比 Xm 点要大，那么 Xm 点为答案，如果 k 小于 Xm，那么 k 为答案。 K 表示最终k点。  
那么f(K)即为所求。  
现在的问题变成，如何快速找到 K 点，通过函数图像可得，随着 a 的单调增加，不同图像的(Xm)点是单调递减的，
这为binary search快速找到 K 点提供了可能性。a 的最大取值可以是股票的最高价格，因为大于等于这个价格，
所有的交易将不在盈利。  

>f(k) = g(x)_max + ak

由于g(x)函数的特性，这里求出的x为 所有可能答案的最小值！例如：当k <= Xm时， k=2   
int[] prices = [3,3,5,0,0,3,1,4]，这里Xm = 2, g(x)求出的x=1，a=2，g(x)在相同获利时取较小
的交易次数。当k > Xm时，交易费用a会收敛到0，所以ak = 0，符合意义。

特别注意：在binary search移动 start 和 end 的时候注意结合函数图像 k 变化的趋势来决定 start 和 end
的移动。



[Leetcode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)  
[大神讲解](https://www.youtube.com/watch?v=lXRe__YD8JY)  
[大神git](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/188.Best-Time-to-Buy-and-Sell-Stock-IV)
