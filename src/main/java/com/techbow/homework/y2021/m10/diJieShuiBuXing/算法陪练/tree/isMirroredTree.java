package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;

import dfsBfs.TreeNode;

public class isMirroredTree {

    public boolean isMirrored(TreeNode root){
        return root == null ?  true : isMirrored(root.left, root.right);
    }

    private boolean isMirrored(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null || left.val != right.val){
            return false;
        }

        return isMirrored(left.left,right.right) && isMirrored(left.right,right.left);
    }
}
