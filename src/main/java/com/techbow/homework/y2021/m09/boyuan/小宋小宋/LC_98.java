package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        int val = root.val;
        return isValid(root.left, min, val) && isValid(root.right, val, max);
    }
}
