package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree.BST;

import dfsBfs.TreeNode;

import java.util.Stack;

public class LC98ValidateBST {


//1 从上到下carry on 一个range，边往下走边validate

    public boolean isValidBST_1(TreeNode root) {
        return upToDownCarryOn(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean upToDownCarryOn(TreeNode root, long minValue, long maxValue) {
        if(root == null){ //走到leaf了 都没有false 所以是BST， base case
            return true;
        }

        if(root.left.val>= root.val || root.right.val <= root.val){//bst无重复值
            return false;
        }

        return upToDownCarryOn(root.left,minValue,root.val)//去左子树更新上边界值
                && upToDownCarryOn(root.right,root.val,maxValue);//去右子树更新下边界值
    }


// 2 从下到上 返回一个范围，来check parent是不是在range里
    //TODO Di
    public boolean isValidBST_2(TreeNode root) {
        return downToUp(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean downToUp(TreeNode root, long minValue, long maxValue) {
return false;
    }


    // 3 用BST特性，递增array，它如果是inorder遍历，他的prev肯定是小于cur的值
    private TreeNode prev = null;
    public boolean isValidBST_3(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!isValidBST_3(root.left)){
            return false;
        }
        //inorder 就是在这个位置区间内处理root
        if(prev != null && prev.val>= root.val){
            return false;
        }
        prev = root;
        //
        return isValidBST_3(root.right);
    }

    //4 stack iterator
    private TreeNode prev_stack = null;
    public boolean isValidBST_4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while(root != null ||!stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{

                root = stack.pop();
                if(prev_stack!= null && prev_stack.val >= root.val){
                    return false;
                }
                prev_stack = root;
                root = root.right;
            }
        }
        return true;
    }
}
