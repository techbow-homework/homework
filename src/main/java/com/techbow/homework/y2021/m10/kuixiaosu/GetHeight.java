package com.techbow.homework.y2021.m10.kuixiaosu;

public class GetHeight {
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max((getHeight(root.left), getHeight(root.right)) + 1;
    }


    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
