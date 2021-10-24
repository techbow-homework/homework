package com.techbow.homework.y2021.m10.mengyu;

import com.techbow.homework.y2021.m09.mengyu.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144PreOrderTraversalIteration {
    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> preorderStack = new Stack<>();
        while (root != null || !preorderStack.isEmpty()) {
            if (root != null) {
                preorderStack.push(root);
                result.add(root.val);
                root = root.left;
            } else {
                root = preorderStack.pop();
                root = root.right;
            }
        }

        return result;
    }
}
