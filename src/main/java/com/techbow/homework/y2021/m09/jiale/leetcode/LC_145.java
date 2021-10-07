package com.techbow.homework.y2021.m09.jiale.leetcode;

import com.techbow.homework.y2021.m09.jiale.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * postorder traversal of bst
 */
public class LC_145 {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorderTraversalRecur(root);
        return result;
    }
    private void postorderTraversalRecur(TreeNode node) {
        if (node == null) return;
        postorderTraversalRecur(node.left);
        postorderTraversalRecur(node.right);
        result.add(node.val);
    }
}
