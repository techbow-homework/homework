package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.tree;

import dfsBfs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if(root == null){
            return ;
        }

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }


    public List<Integer> inorderTraversal_stack(TreeNode root) {
        if(root == null){
            throw new IllegalArgumentException("root cannot be null");
        }

        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root !=null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
