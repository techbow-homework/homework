package com.techbow.homework.y2021.m10.Jacob;

/*
public class LC_124 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        int sum = root.val + left + right;
        max = Math.max(max, sum);
        return root.val + Math.max(left, right);
    }
}
       /*
第32行计算左边分支最大值，左边分支如果为负数则为0
第33行计算左边分支最大值，左边分支如果为负数则为0
第34行计算出root+left+right的总和
第35行update sum的最大值
第36行return root.val然后加上左右两边的最大值。
*/

