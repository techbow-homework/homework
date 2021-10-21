package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree.BST;

import dfsBfs.TreeNode;

public class LC270 {

    int closest = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        helper(root,target);
        return closest;
    }

    public void helper(TreeNode root, double target) {
        if(root == null){
            return ;
        }
        if(target>=root.val){
            helper(root.right,target);
        }

        if(Math.abs(root.val - target)< Math.abs( closest - target)){
            closest = root.val;
        }


        if(target<=root.val){
            helper(root.left,target);
        }

    }


    public int closestValue_iterator(TreeNode root, double target) {

        int res = root.val;

        while(root != null){
            if(Math.abs(root.val - target) < Math.abs(res - target)){
                res = root.val;
            }
            if(target > root.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.right = node;
        root.left = null;

    }
}
