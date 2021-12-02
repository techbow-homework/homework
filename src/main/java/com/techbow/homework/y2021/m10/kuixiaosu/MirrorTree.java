package com.techbow.homework.y2021.m10.kuixiaosu;

public class MirrorTree {
    public boolean mirror(TreeNode root) {
        // corner case
        return root == null ? true : mirror(root.left, root.right);
    }
    private boolean mirror(TreeNode left, TreeNode right) {  //helper函数
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}
