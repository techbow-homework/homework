package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (isBalanced(root.right) && isBalanced(root.left) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1);
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
