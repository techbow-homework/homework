package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94inorderIteration {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        /*
         1
       2   3
      4 5 6 7
         */
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }

        return result;
    }
}
