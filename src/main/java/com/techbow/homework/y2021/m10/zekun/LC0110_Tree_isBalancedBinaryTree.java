package com.techbow.homework.y2021.m10.zekun;

public class LC0110_Tree_isBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        //cc
        if(root == null) return true;
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root){
        //basecase
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }else{
            return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1: -1;
        }
    }
}
