package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;


import dfsBfs.TreeNode;

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */
public class LC110BalancedBinaryTree {


    // 从上到下 Onlogn
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left - right)>2)return false;
        return isBalanced(root.left)&& isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left , right) +1;
    }


    //从下到上 On
    public boolean isBalanced_downUp(TreeNode root) {

        return getBottomHeight(root) == -1 ? false : true;
    }

    private int getBottomHeight(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = getBottomHeight(root.left);
        int right = getBottomHeight(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) >= 2){
            return -1;
        }

        return Math.max(left,right) + 1;
    }


}
