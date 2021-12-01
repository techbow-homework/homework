###解题思路：
一个经典问题， dp的定义为：
>dp[i]: the number of distinct subsequences of s from [1, i]。  
> 注意这里并不是ending with s[i]，并且 包含 null。

X X X X X X i  
X X X X  
X X X  
X X X  
X X  
X  
_  
当 idx 移动到 i 位置时，有两种选择：
1. 将 s[i] 加入到之前的distinct subsequences中，这时 dp[i] = dp[i - 1];  
   X X X X X X i  
   X X X X s[i]   
   X X X s[i]  (1)  
   X X X s[i]  
   X X s[i]  
   X s[i]  
   s[i]
2. 不将 s[i] 加入到之前的distinct subsequences中，这时 dp[i] = dp[i - 1];  
   X X X X X X i  
   X X X X  (2)  
   X X X  
   X X X  
   X X  
   X  
   _

所以dp[i] = dp[i - 1] * 2; 但是这种情况下 如果(2)的最后一个char 与 s[i]相同，那么(1)有可能与
(2)重复，这里用 A 表示当前遇到的 char，a 表示之前distinct subsequence的最后一个char，  
X X X a  
X X X A  
为了排除duplicate，需要 减去 当前距离当前 i 距离最近的 相同字符 所在位置 j 的 the number of
distinct subsequences 但是包括s[j]，也就是dp[j - 1].  
所以dp[i] = dp[i - 1] * 2 - dp[j - 1];这里可以通过记录一个 26个英文字符最后出现位置 的array，
来快速找到，最近一个出现的重复字符的idx， 并且int[] last 可以跟 dp同时完成。  
这里注意dp[0]表示  
[视频讲解参考](https://www.youtube.com/watch?v=boT3gkVPlH4)  
[大神git](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/940.Distinct-Subsequences-II)