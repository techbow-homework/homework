package com.techbow.homework.y2021.m10.qiangzhai;

public class LC111_BalancedBinaryTree {
    //top down
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        //do sth
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        //recursion
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }

    //bottom up
    public boolean isBalanced(TreeNode root) {
        //cc
        if (root == null) return true;
        return heightBalanced(root) == -1 ? false : true;
    }
    private int heightBalanced(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = heightBalanced(root.left);
        int rightHeight = heightBalanced(root.right);
        //减枝条件，迅速向上return
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
