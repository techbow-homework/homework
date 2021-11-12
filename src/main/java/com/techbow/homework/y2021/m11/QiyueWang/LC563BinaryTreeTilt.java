package com.techbow.homework.y2021.m11.QiyueWang;

public class LC563BinaryTreeTilt {
    private int res = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        findSum(root);
        return res;
    }
    private int findSum(TreeNode root){
        if(root == null) return 0;
        int l = findSum(root.left);
        int r = findSum(root.right);
        res += Math.abs(l - r);
        return l + r + root.val;
    }
}