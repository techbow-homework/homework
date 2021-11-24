package com.techbow.homework.y2021.m10.kuixiaosu;

public class BST {
    public boolean isBST(TreeNode root) {
        // corner case
        if(root == null) return true;
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, int lowerBound, int upperBound) {
        // base case
        if(root == null) return true;
        if (root.val >= upperBound || root.val <= lowerBound) return false;
        return isBST(root.left, lowerBound, root.val) && isBST(root.right, root.val, upperBound);
    }
    //时间复杂度：O（n）
}
