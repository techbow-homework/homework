解题思路：
博弈问题，函数的定义为：在[i, j]区间player1可以得到的最大分数。这里player1选择最左边的num时，player2会选择new board中他会得到的最大分数的
方案，所以player1再次选择时，他只能从再生成的board中选择最大值；player1开始选择右边时，逻辑一样。这里idx连续，输出为int，可以用dp优化。
为区间型dp。同[LC132](https://github.com/Ryannx/Leetcode/tree/master/DP/src/LC_312)