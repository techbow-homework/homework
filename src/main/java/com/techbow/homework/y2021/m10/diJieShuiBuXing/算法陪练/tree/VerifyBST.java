package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;

import dfsBfs.TreeNode;

public class VerifyBST {
    public boolean verifyBST(TreeNode root){
        return verifyHelper(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean verifyHelper(TreeNode root, int minValue, int maxValue) {
        if(root == null){
            return true;
        }

        if(root.val >= maxValue || root.val <= minValue){ //bst无重复值
            return false;
        }

      return  verifyHelper(root.left,minValue,root.val)//去左子树更新上边界值
        && verifyHelper(root.right,root.val,maxValue);//去右子树更新下边界值
    }
}
