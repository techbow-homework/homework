package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;

    }
}
