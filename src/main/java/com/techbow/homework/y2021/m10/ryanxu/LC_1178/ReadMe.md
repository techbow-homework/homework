###解题思路：
brute force解法，m = words.length, n = puzzles.length，时间复杂度O(mn)，所有的word和puzzle只由小写字母组成，
所以一共只由26种情况。用bitmask来表示的word，可以将含有相同字母的word进行合并来优化m。对于每个puzzle来遍历所有的word，
这里有一个trick，可以用for loop来解决  

>for (subset = bitmask; subsets >= 0; subset = (subset - 1) & bitmask) {
  // do what you want with the current subset...
}

[Leetcode](https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/solution/)