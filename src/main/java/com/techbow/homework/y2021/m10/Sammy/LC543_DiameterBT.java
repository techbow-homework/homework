package com.techbow.homework.y2021.m10.Sammy;

public class LC543_DiameterBT {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // corner case
        if (root == null) return 0;

        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return -1;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(left + right + 2, max);
        return Math.max(left, right) + 1;
    }
}
