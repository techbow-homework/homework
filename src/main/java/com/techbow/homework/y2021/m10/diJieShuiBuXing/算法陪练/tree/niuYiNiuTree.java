package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;

import dfsBfs.TreeNode;

public class niuYiNiuTree {

    public boolean niuYiNiu(TreeNode root){
        return isNiuYiNiu(root.left,root.right);
    }

    private boolean isNiuYiNiu(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return  true;
        }

        if(left == null || right== null || left.val != right.val){
            return false;
        }

        return isNiuYiNiu(left.left, right.right) && isNiuYiNiu(left.right,right.left)
                || isNiuYiNiu(left.left,right.left) && isNiuYiNiu(left.right,right.right);
    }
}
