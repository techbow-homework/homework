package com.techbow.homework.y2021.m09.WooWooLily;

//validate binary search tree
//left sub trees < root < right sub trees

public class LC_98 {

    public boolean isBST(TreeNode root) {
        return helper(root,null,null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
