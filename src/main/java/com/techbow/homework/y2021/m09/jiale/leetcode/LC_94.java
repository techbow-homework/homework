package com.techbow.homework.y2021.m09.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * inorder traversal of bst
 */
public class LC_94 {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        inorderTraversalRecur(root);
        return result;
    }
    private void inorderTraversalRecur(TreeNode node) {
        if (node == null) return;
        inorderTraversalRecur(node.left);
        result.add(node.val);
        inorderTraversalRecur(node.right);
    }
}
