package com.techbow.homework.y2021.m10.Sammy;

public class LC124_BTMaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left_gain = Math.max(dfs(root.left), 0);
        int right_gain = Math.max(dfs(root.right), 0);

        int curSum = root.val + left_gain + right_gain;
        max = Math.max(max, curSum);
        return root.val + Math.max(left_gain, right_gain);
    }
}
