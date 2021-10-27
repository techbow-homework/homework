package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;

import dfsBfs.TreeNode;

public class LC101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        //因为是要比对两个nodes的子树关系，所以需要两个input，所以需要override

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
    }

}
