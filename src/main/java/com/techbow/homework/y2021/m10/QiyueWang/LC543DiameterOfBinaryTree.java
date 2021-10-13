package com.techbow.homework.y2021.m10.QiyueWang;

public class LC543DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)), height(root.left) + height(root.right));
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        int lH = height(root.left);
        int rH = height(root.right);
        return Math.max(lH,rH) + 1;
    }
}
