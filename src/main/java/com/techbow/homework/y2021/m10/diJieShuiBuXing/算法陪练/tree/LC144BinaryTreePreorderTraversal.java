package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;


import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [1,2]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [1,2]
 */
public class LC144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        preorder(root, res);
        return res;
    }


    private void preorder(TreeNode root, List<Integer> res){
        if( root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }


    public List<Integer> preorderTraversal_stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }else{
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
}
