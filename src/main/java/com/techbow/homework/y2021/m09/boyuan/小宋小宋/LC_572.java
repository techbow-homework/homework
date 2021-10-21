package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return sub(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean sub(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return sub(root.right, subRoot.right) && sub(root.left, subRoot.left);
    }
}
