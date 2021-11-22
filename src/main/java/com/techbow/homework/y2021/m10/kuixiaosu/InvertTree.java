package com.techbow.homework.y2021.m10.kuixiaosu;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
