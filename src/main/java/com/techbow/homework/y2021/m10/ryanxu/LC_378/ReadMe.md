### 解题思路：
题目要求在单调递增矩阵中找到第k小的数字，由题可知，matrix[0][0] is min, matrix[n - 1][n - 1] is max
;所以可以首先用binary search来猜数val，然后用binary search在每一行或者列中计算出有多少个数小于等于val。