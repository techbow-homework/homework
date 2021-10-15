package com.techbow.homework.y2021.m09.WooWooLily;

//invert binary tree
//O(n)
public class LC_226 {
    public TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertBinaryTree(root.left);
        TreeNode right = invertBinaryTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
