package com.techbow.homework.y2021.m10.Sammy;

import java.util.Stack;

public class LC114_FlattenBTtoLinkedL {
    //dfs version
    public void flatten(TreeNode root) {
        helper(root);
    }

    private TreeNode helper(TreeNode root){
        //terminated base case...
        if(root == null){
            return null;
        }

        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        //both call 到底先

        if(left == null && right == null){
            return root;
        }

        if(left != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return right == null ? left : right;
    }
    //Stack
    public void flattenInStack(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);

            if(!stack.isEmpty()){
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }
}
